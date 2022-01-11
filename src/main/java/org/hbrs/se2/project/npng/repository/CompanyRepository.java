package org.hbrs.se2.project.npng.repository;

import org.hbrs.se2.project.npng.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
