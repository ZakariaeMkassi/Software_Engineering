package org.hbrs.se2.project.npng.repository;

import org.hbrs.se2.project.npng.entity.ApplicationLetter;
import org.hbrs.se2.project.npng.entity.Company;
import org.hbrs.se2.project.npng.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findAllByCompany_id(int company_id);
}