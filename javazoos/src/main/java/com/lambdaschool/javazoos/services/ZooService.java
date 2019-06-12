package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Telephone;
import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.views.CountAnimalsInZoos;

import java.util.ArrayList;

public interface ZooService
{
    ArrayList<Zoo> findAll();

    void delete(long id);

    ArrayList<CountAnimalsInZoos> getCountAnimalsInZoos();
}
