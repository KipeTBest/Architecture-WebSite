package ru.kpfu.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private Integer position;
    private Integer score;

}
