package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.repos.ZooRepository;
import com.lambdaschool.javazoos.views.CountAnimalsInZoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    private ZooRepository zoorepos;

    @Override
    public ArrayList<Zoo> findAll()
    {
        ArrayList<Zoo> list = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if(zoorepos.findById(id).isPresent())
        {
            zoorepos.deleteAnimalsFromZooanimals(id);
            zoorepos.deleteById(id);
        }

    }

    @Override
    public ArrayList<CountAnimalsInZoos> getCountAnimalsInZoos()
    {
        return zoorepos.getCountAnimalsInZoos();
    }

}
