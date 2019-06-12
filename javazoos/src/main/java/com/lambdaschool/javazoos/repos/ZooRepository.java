package com.lambdaschool.javazoos.repos;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.views.CountAnimalsInZoos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{
    //SELECT a.zooid, z.zooname, count(a.animalid) as countsanimals
    //FROM zooanimals a
    //INNER JOIN zoo z
    //on a.zooid = z.zooid
    //GROUP BY a.zooid, z.zooname

    @Query(value = "SELECT a.zooid, z.zooname, count(a.animalid) as countsanimals FROM zooanimals a INNER JOIN zoo z GROUP BY a.zooid, z.zooname", nativeQuery = true)
    ArrayList<CountAnimalsInZoos> getCountAnimalsInZoos();

    @Modifying
    @Query(value = "DELETE FROM zooanimals WHERE zooid = :zooid", nativeQuery = true)
    void deleteAnimalsFromZooanimals(long zooid);
}
