package ru.kpfu.itis.repository;

import java.util.List;

public interface BaseRepo <ENTITY, ID>{

    ENTITY saveInfo(ENTITY entity);
    List<ENTITY> findAll();
    ENTITY findById(ID id);
    ENTITY updateInfo(ENTITY entity);
    ENTITY deleteById(ID id);
}
