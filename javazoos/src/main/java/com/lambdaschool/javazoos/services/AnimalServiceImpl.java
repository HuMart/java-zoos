package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.repos.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "studentService")
public class AnimalServiceImpl implements AnimalService
{
    @Autowired
    private AnimalRepository animalrepo;
}
