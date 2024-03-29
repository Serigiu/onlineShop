package com.sda.OnlineShop.validators;

import com.sda.OnlineShop.dto.RegistrationDto;
import com.sda.OnlineShop.entities.User;
import com.sda.OnlineShop.mapper.UserMapper;
import com.sda.OnlineShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Optional;

@Service
public class RegistrationDtoValidator {
    @Autowired
    private UserRepository userRepository;

    public void validate(RegistrationDto registrationDto, BindingResult bindingResult) {
        Optional<User> optionalUser = userRepository.findByEmailAddress(registrationDto.getEmailAddress());
        if (optionalUser.isPresent()) {
            FieldError fieldError = new FieldError("registrationDto", "emailAddress", "The email is already in use!");
            bindingResult.addError(fieldError);
        }

        if (!(registrationDto.getPassword().equals(registrationDto.getConfirmPassword()))) {
            FieldError fieldError = new FieldError("registrationDto", "confirmPassword", "The passwords do not match!");
        }

        if (registrationDto.getEmailAddress().isEmpty()) {
            FieldError fieldError = new FieldError("registrationDto", "emailAddress", "Please provide an email address!");
        }

        /*if (registrationDto.getEmailAddress().compareTo() {
            FieldError fieldError = new FieldError("registrationDto", "emailAddress", "Please provide an email address!");
        }*/

        if (registrationDto.getFullName().isEmpty()) {
            FieldError fieldError = new FieldError("registrationDto", "fullName", "Please provide a name");
        }

    }
}
