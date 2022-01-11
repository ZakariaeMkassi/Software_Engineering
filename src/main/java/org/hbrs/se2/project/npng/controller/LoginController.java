package org.hbrs.se2.project.npng.controller;

import org.hbrs.se2.project.npng.controller.exception.DatabaseUserException;
import org.hbrs.se2.project.npng.dto.UserDTO;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    private User user;

    public boolean authentificate(String eMail, String password) throws DatabaseUserException {
        this.user = this.getUserWithJPA(eMail, password);
        if (user == null){
            return false;
        }
        return true;
    }

    public User getCurrentUser(){
        return this.user;
    }

    public User getUserWithJPA(String eMail, String password) throws DatabaseUserException{

        User myUser;
        try{

            myUser = userRepository.findUserByMailAndPassword(eMail, password);
        }catch ( org.springframework.dao.DataAccessResourceFailureException e ) {

            throw new DatabaseUserException("A failure occured while trying to connect to database with JPA");
        }
        return myUser;
    }
}
