package org.hbrs.se2.project.npng.repository;

import org.hbrs.se2.project.npng.entity.ApplicationLetter;
import org.hbrs.se2.project.npng.entity.JobAdvertisement;
import org.hbrs.se2.project.npng.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApplicationletterRepository extends JpaRepository<ApplicationLetter, Integer> {
    List<ApplicationLetter> findAllByStudent(Student student);
    List<ApplicationLetter> findAllByJobAdvertisement(JobAdvertisement jobAdvertisement);
}