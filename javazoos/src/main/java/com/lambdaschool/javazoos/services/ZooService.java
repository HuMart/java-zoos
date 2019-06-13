package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Zoo;

import java.util.ArrayList;

public interface ZooService
{
    ArrayList<Zoo> findAll();

    Zoo findZooById(long id);

    void delete(long id);

    Zoo save(Zoo zoo);

    Zoo update(Zoo zoo, long id);
}
