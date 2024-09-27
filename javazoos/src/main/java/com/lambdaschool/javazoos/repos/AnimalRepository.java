package com.lambdaschool.javazoos.repos;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.views.CountAnimalsInZoos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    //    SELECT a.animalid, a.animaltype, count(zooid) as countzoos
    //    FROM zooanimals z
    //    INNER JOIN animals a
    //    ON z.animalid = a.animalid
    //    GROUP BY z.animalid, a.animaltype
    @Query(value = "SELECT a.animalid, a.animaltype, count(zooid) as countzoos FROM zooanimals z INNER JOIN animals a ON z.animalid = a.animalid GROUP BY z.animalid, a.animaltype",
           nativeQuery = true)
    ArrayList<CountAnimalsInZoos> getCountAnimalsInZoos();
}


