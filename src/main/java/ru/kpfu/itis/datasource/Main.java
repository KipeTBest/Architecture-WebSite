package ru.kpfu.itis.datasource;

import lombok.Data;
import ru.kpfu.itis.repository.impl.BaseRepoMessages;
import ru.kpfu.itis.repository.impl.BaseRepoUsers;

import javax.sql.DataSource;

public class Main {

    public static void main(String[] args) {

        DataSource source = new MySimpleDataSource("postgres", "postgres",
                "jdbc:postgresql://localhost:5432/ArchitectureDB");
        BaseRepoMessages messages = new BaseRepoMessages(source);
        System.out.println(messages.findAll().toString());
    }

}
