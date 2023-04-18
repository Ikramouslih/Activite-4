package ma.enset.hospitalapp.repository;

import ma.enset.hospitalapp.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

//L'utilisation du module Spring data JPA
//Facilite la technique ORM
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContains(String kw, Pageable pageable);

}

//Spring Data : Module de spring, gère implecitement les objets EntityManager pour gérer la persistance
//en plus des methodes classiques du JPARepository, il permet de créer des methodes en déclarant le prototype seulement,
//ainsi que la creation des methodes à partir d'une requette HQL (Hibernate query language)