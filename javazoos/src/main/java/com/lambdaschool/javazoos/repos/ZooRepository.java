package com.lambdaschool.javazoos.repos;

import com.lambdaschool.javazoos.models.Zoo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ZooRepository extends CrudRepository<Zoo, Long>
{
    Zoo findByZooid(long id);

    @Modifying
    @Query(value = "DELETE FROM zooanimals WHERE zooid = :zooid", nativeQuery = true)
    void deleteZoosfromZooanimals (long zooid);

    @Modifying
    @Query(value = "DELETE FROM telephones WHERE zooid = :zooid", nativeQuery = true)
    void deletePhonesFromZoos (long zooid);
}
