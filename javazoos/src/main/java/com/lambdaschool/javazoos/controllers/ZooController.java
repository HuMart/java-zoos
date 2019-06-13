package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;

@RestController
public class ZooController
{
    @Autowired
    private ZooService zooService;


    @GetMapping(value = "/zoos/zoos", produces = {"application/json"})
    public ResponseEntity<?> getAllZoos()
    {
        ArrayList<Zoo> zooList = zooService.findAll();
        return new ResponseEntity<>(zooList, HttpStatus.OK);
    }

    @GetMapping(value = "/zoos/zoos/{zooid}",
                produces = {"application/json"})
    public ResponseEntity<?> getZooById(
            @PathVariable
                    long zooid)
    {
        Zoo z = zooService.findZooById(zooid);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    @PutMapping(value = "/admin/zoos/{zooid}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateZoo(
            @RequestBody
                    Zoo updateZoo,
            @PathVariable
                    long zooid)
    {
        zooService.update(updateZoo, zooid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/admin/zoos",
                 consumes = {"application/json"},
                 produces = {"application/json"})
    public ResponseEntity<?> addNewZoo(@Valid
                                       @RequestBody
                                               Zoo newZoo)
    {
        newZoo = zooService.save(newZoo);

        HttpHeaders responseHeader = new HttpHeaders();
        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{zooid}").buildAndExpand(newZoo.getZooid()).toUri();
        responseHeader.setLocation(newZooURI);

        return new ResponseEntity<>(null, responseHeader, HttpStatus.OK);
    }

    @DeleteMapping("/admin/zoos/{zooid}")
    public ResponseEntity<?> deleteZooById(
            @PathVariable
                    long zooid)
    {
        zooService.delete(zooid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
