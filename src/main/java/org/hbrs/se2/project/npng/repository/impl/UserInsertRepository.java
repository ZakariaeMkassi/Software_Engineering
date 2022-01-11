package org.hbrs.se2.project.npng.repository.impl;

import org.hbrs.se2.project.npng.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public interface UserInsertRepository extends JpaRepository<User, Integer> {



}
