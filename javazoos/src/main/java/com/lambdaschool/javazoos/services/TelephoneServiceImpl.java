package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Telephone;
import com.lambdaschool.javazoos.repos.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service(value = "telephoneService")
public class TelephoneServiceImpl implements TelephoneService
{
    @Autowired
    private TelephoneRepository phonerepos;

    @Override
    public ArrayList<Telephone> findAll()
    {
        ArrayList<Telephone> list = new ArrayList<>();
        phonerepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id)
    {
       if (phonerepos.findById(id).isPresent())
       {
           phonerepos.deleteById(id);
       }
    }
}
