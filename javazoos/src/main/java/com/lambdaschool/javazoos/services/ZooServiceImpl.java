package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Telephone;
import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.repos.ZooRepository;
import com.lambdaschool.javazoos.views.CountAnimalsInZoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public Zoo findZooById(long id)
    {
        return zoorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if (zoorepos.findById(id).isPresent())
        {
            zoorepos.deleteZoosfromZooanimals(id);
            zoorepos.deletePhonesFromZoos(id);
            zoorepos.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo)
    {
        Zoo newZoo = new Zoo();

        newZoo.setZooname(zoo.getZooname());

        for (Telephone t : zoo.getTelephones())
        {
            newZoo.getTelephones().add(new Telephone(t.getPhonetype(), t.getPhonenumber()));
        }

        return newZoo;
    }

    @Override
    public Zoo update(Zoo zoo, long id) {
        Zoo currentZoo = zoorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (zoo.getZooname() != null) {
            currentZoo.setZooname(zoo.getZooname());
        }

        if (zoo.getTelephones().size() > 0 ) {
            for (Telephone t : zoo.getTelephones()) {
                currentZoo.getTelephones().add(new Telephone(t.getPhonetype(), t.getPhonenumber()));
            }
        }

        return zoorepos.save(currentZoo);
    }
}
