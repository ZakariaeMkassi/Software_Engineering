package org.hbrs.se2.project.npng.repository;

import org.hbrs.se2.project.npng.dto.UserDTO;
import org.hbrs.se2.project.npng.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByMail(String mail);
    User findUserByMailAndPassword (String eMail, String password);
    User findUserByPassword(String password);

}