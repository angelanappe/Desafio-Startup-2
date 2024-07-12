package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.connection.DatabaseConnection;
import cl.praxis.model.Direccion;
import cl.praxis.model.Usuario;

public class UsuarioDAO {

    public List<Usuario> usuariosConDireccion() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT u.id, u.correo, u.nick, u.nombre, u.peso, r.nombre as rol, d.nombre as direccion_nombre, d.numeracion as direccion_numeracion " +
                     "FROM usuarios u " +
                     "JOIN roles_usuarios ru ON u.id = ru.usuario_id " +
                     "JOIN roles r ON ru.rol_id = r.id " +
                     "LEFT JOIN direcciones d ON u.id = d.usuario_id " +
                     "WHERE r.id IN (1, 2)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String correo = resultSet.getString("correo");
                String nick = resultSet.getString("nick");
                String nombre = resultSet.getString("nombre");
                int peso = resultSet.getInt("peso");
                String rol = resultSet.getString("rol");
                String direccionNombre = resultSet.getString("direccion_nombre");
                String direccionNumeracion = resultSet.getString("direccion_numeracion");

                Direccion direccion = new Direccion(direccionNombre, direccionNumeracion);

                Usuario usuario = new Usuario(id, correo, nick, nombre, peso, new ArrayList<>(), rol);
                usuario.getDirecciones().add(direccion);

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario validateUsuario(String correo, String password) {
        Usuario usuario = null;
        String sql = "SELECT u.id, u.correo, u.nick, u.nombre, u.peso, r.nombre as rol " +
                     "FROM usuarios u " +
                     "JOIN roles_usuarios ru ON u.id = ru.usuario_id " +
                     "JOIN roles r ON ru.rol_id = r.id " +
                     "WHERE u.correo = ? AND u.password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, correo);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nick = resultSet.getString("nick");
                    String nombre = resultSet.getString("nombre");
                    int peso = resultSet.getInt("peso");
                    String rol = resultSet.getString("rol");

                    usuario = new Usuario(id, correo, nick, nombre, peso, new ArrayList<>(), rol);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}