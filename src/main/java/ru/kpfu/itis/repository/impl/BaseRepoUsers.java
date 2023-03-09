package ru.kpfu.itis.repository.impl;


import lombok.SneakyThrows;
import ru.kpfu.itis.models.UserModel;
import ru.kpfu.itis.repository.BaseRepo;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class BaseRepoUsers implements BaseRepo<UserModel, UUID> {

    private final DataSource dataSource;

    public BaseRepoUsers(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public final Function<ResultSet, UserModel> func_map = f -> {
        try {
            String name = f.getString("u_name");
            String password = f.getString("u_password");
            String login = f.getString("u_email");
            Integer position = f.getInt("u_position");
            Integer score = f.getInt("u_score");
            return UserModel.builder()
                    .score(score)
                    .name(name)
                    .email(login)
                    .password(password)
                    .position(position).build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    //language=SQL
    public final static String SAVE_USER = "INSERT INTO user_model" +
            "(u_id,u_name,u_email,u_password,u_score,u_point)" +
            " VALUES (?,?,?,?,?,?)";
    //language=SQL
    public final static String FIND_ALL = "SELECT * FROM user_model";
    //language=SQL
    public final static String FIND_BY_ID = "SELECT * FROM user_model WHERE id = ?";
    //language=SQL
    public final static String FIND_BY_EMAIL_ADN_PASSWORD = "SELECT * FROM user_model WHERE email = ? and password = ?";


    @Override
    public UserModel saveInfo(UserModel userModel) {
        System.out.println("START SAVING USER");

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SAVE_USER, Statement.RETURN_GENERATED_KEYS);
        ){



            statement.setString(1, userModel.getEmail());
            statement.setString(2, userModel.getPassword());
            statement.setString(3, userModel.getName());
            statement.setString(3, userModel.getName());
            statement.setInt(4, userModel.getPosition());
            statement.setInt(5, userModel.getPosition());

            int afRows = statement.executeUpdate();

            if (afRows != 1){

                System.out.println("NO AFFECTED ROWS TROUBLE IN: METHOD SAVE");
                throw new SQLException("NO AFFECTED ROWS TROUBLE IN: METHOD SAVE");
            }

            System.out.println("point: ID GENERATION");
            // ssh be like:)
            ResultSet keygen = statement.getGeneratedKeys();

            if (keygen.next()){

                userModel.setId(UUID.fromString(keygen.getString("id")));

            }else {

                throw new RuntimeException("keygen was failed");

            }

            System.out.println("ID GENERATED: " + userModel.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userModel;
    }

    @Override
    public List<UserModel> findAll() {
        List<UserModel> userModels = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.prepareStatement(FIND_ALL)){
                ResultSet set = statement.executeQuery(FIND_ALL);
                while (set.next()){
                    userModels.add(func_map.apply(set));
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userModels;
    }

    @Override
    public UserModel findById(UUID uuid) {

        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID);
        ){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return func_map.apply(rs);
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public UserModel updateInfo(UserModel userModel) {
        return null;
    }

    @Override
    public UserModel deleteById(UUID uuid) {
        return null;
    }
}
