package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Telephone;

import java.util.ArrayList;

public interface TelephoneService
{
    ArrayList<Telephone> findAll();

    void delete (long id);
}
