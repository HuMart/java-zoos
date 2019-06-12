package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooController
{
    @Autowired
    private ZooService zooService;


    @GetMapping(value = "/zoos/zoos", produces = {"application/json"})
    public ResponseEntity<?> findAllZoos()
    {
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/animals/count")
    public ResponseEntity<?> getCountAnimalsInZoos()
    {
        return new ResponseEntity<>(zooService.getCountAnimalsInZoos(), HttpStatus.OK);
    }


}
