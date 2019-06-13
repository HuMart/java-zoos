package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.repos.AnimalRepository;
import com.lambdaschool.javazoos.views.CountAnimalsInZoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "studentService")
public class AnimalServiceImpl implements AnimalService
{
    @Autowired
    private AnimalRepository animalrepo;

    @Override
    public ArrayList<CountAnimalsInZoos> getCountAnimalsInZoos()
    {
        return animalrepo.getCountAnimalsInZoos();
    }
}
