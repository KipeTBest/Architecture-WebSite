package ru.kpfu.itis.repository.impl;

import ru.kpfu.itis.models.Message;
import ru.kpfu.itis.models.UserModel;
import ru.kpfu.itis.repository.BaseRepo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public class BaseRepoMessages implements BaseRepo<Message, UUID> {
    private final DataSource dataSource;

    public BaseRepoMessages(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public final Function<ResultSet, Message> func_map = f -> {
        try {
            String name = f.getString("u_name");
            String info = f.getString("u_info");
            String author = f.getString("u_author");
            String uuid = f.getString("u_id");
            return Message.builder()
                    .author(author)
                    .info(info)
                    .name(name)
                    .uuid(UUID.fromString(uuid))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    //language=SQL
    public final static String SAVE_USER = "INSERT INTO msg_model" +
            "(u_id,u_name,u_info,u_author)" +
            " VALUES (?,?,?,?)";
    //language=SQL
    public final static String FIND_ALL = "SELECT * FROM msg_model";
    //language=SQL
    public final static String FIND_BY_ID = "SELECT * FROM msg_model WHERE u_id = ?";

    @Override
    public Message saveInfo(Message message) {
        return null;
    }

    @Override
    public List<Message> findAll() {
        List<Message> messages = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet set = statement.executeQuery(FIND_ALL);
            while (set.next()){
                messages.add(func_map.apply(set));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    @Override
    public Message findById(UUID uuid) {
        return null;
    }

    @Override
    public Message updateInfo(Message message) {
        return null;
    }

    @Override
    public Message deleteById(UUID uuid) {
        return null;
    }
}
