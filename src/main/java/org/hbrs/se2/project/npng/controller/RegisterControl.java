package org.hbrs.se2.project.npng.controller;

import org.hbrs.se2.project.npng.controller.exception.DatabaseLayerException;
import org.hbrs.se2.project.npng.entity.User;
import org.hbrs.se2.project.npng.repository.UserRepository;
import org.springframework.stereotype.Component;


@Component
public class RegisterControl {

    private UserRepository userRepository;

    public RegisterControl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public boolean checkExistingEmail(String email) throws DatabaseLayerException {
        User user = userRepository.findUserByMail(email);
        if(user == null){
            return false;
        }
        else{
            return true;
        }
    }
}
