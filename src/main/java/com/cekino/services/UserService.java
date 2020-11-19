package com.cekino.services;

import com.cekino.entities.User;
import com.cekino.exceptions.UserExceptions;
import com.cekino.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new IllegalArgumentException(UserExceptions.GET_ALL_USER_EXCEPTION);
        }

    }

    public ResponseEntity<User> getUserById(Long id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(UserExceptions.USER_NOT_FOUND));
        return ResponseEntity.ok().body(user);
    }

    public User insertUser(User user) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        User userByUserName = userRepository.findUserByUserName(user.getUserName());
        User userByEmail = userRepository.findUserByEmail(user.getEmail());
        User userByIdentityNumber = userRepository.findUserByIdentityNumber(user.getIdentityNumber());

        if (user.getName() == null || user.getName().equals("")
                && user.getSurname() == null || user.getSurname().equals("")
                && user.getUserName() == null || user.getUserName().equals("")
                && user.getEmail() == null || user.getEmail().equals("")) {
            throw new IllegalArgumentException(UserExceptions.INSERT_EXCEPTION + UserExceptions.COMPULSORY_FIELDS_EXCEPTION + UserExceptions.COMPULSORY_FIELDS);
        }

        if (userByEmail != null) {
            throw new IllegalArgumentException(UserExceptions.INSERT_EXCEPTION + UserExceptions.EMAIL_ALREADY_EXISTS);
        } else if (isContainsEmail(user.getEmail()) == false) {
            throw new IllegalArgumentException(UserExceptions.INSERT_EXCEPTION + UserExceptions.INVALID_EMAIL);
        }

        if (userByUserName != null) {
            throw new IllegalArgumentException(UserExceptions.INSERT_EXCEPTION + UserExceptions.USER_NAME_ALREADY_EXISTS);
        } else if (isValidUserName(user.getUserName()) == false) {
            throw new IllegalArgumentException(UserExceptions.INSERT_EXCEPTION + UserExceptions.MIN_CHARACTER_EXCEPTION);
        }

        if (userByIdentityNumber != null) {
            throw new IllegalArgumentException(UserExceptions.INSERT_EXCEPTION + UserExceptions.IDENTITY_NUMBER_ALREADY_EXISTS);
        }

        if (user.getIdentityNumber().trim().length() != 11) {
            throw new SQLException(UserExceptions.INSERT_EXCEPTION + UserExceptions.IDENTITY_NUMBER_EXCEPTION);
        }

        if (isValidGender(user.getGender()) != true) {
            throw new SQLException(UserExceptions.INSERT_EXCEPTION + UserExceptions.GENDER_EXCEPTION);
        }

        if (isValidAge(user.getAge()) != true) {
            throw new Exception(UserExceptions.INSERT_EXCEPTION + UserExceptions.INVALID_AGE);
        }

        user.setCreatedAd(date.format(formatter));

        return userRepository.save(user);
    }

    public ResponseEntity<User> updateUserById(Long id, User userDetails) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(UserExceptions.USER_NOT_FOUND)
        );
        if (userDetails.getName() != null) {
            user.setName(userDetails.getName());
        }

        if (userDetails.getSurname() != null) {
            user.setSurname(userDetails.getSurname());
        }

        if (userDetails.getAge() != null) {
            if (isValidAge(userDetails.getAge()) != false) {
                user.setAge(userDetails.getAge());
            }
        }

        if (userDetails.getUserName() != null) {
            if (isValidUserName(userDetails.getUserName()) == false) {
                throw new IllegalArgumentException(UserExceptions.UPDATE_BY_ID_EXCEPTION + UserExceptions.MIN_CHARACTER_EXCEPTION);
            } else if (userRepository.findUserByUserName(userDetails.getUserName()) != null) {
                throw new IllegalArgumentException(UserExceptions.UPDATE_BY_ID_EXCEPTION + UserExceptions.USER_NAME_ALREADY_EXISTS);
            }
        }

        if (userDetails.getEmail() != null) {
            if (isContainsEmail(userDetails.getEmail()) == false) {
                throw new IllegalArgumentException(UserExceptions.UPDATE_BY_ID_EXCEPTION + UserExceptions.INVALID_EMAIL);
            } else if (userRepository.findUserByEmail(userDetails.getEmail()) != null) {
                throw new IllegalArgumentException(UserExceptions.UPDATE_BY_ID_EXCEPTION + UserExceptions.EMAIL_ALREADY_EXISTS);
            }

            user.setEmail(userDetails.getEmail());
        }

        if (userDetails.getGender() != null) {
            user.setGender(userDetails.getGender());
        }

        user.setUpdatedAt(date.format(formatter));

        if (userDetails.getIdentityNumber() != null) {
            throw new Exception(UserExceptions.UPDATE_BY_ID_EXCEPTION
                    + UserExceptions.UPDATE_NOT_IDENTITY_NUMBER);
        }

        if (userDetails.getId() != null) {
            throw new Exception(UserExceptions.UPDATE_BY_ID_EXCEPTION
                    + UserExceptions.UPDATE_NOT_ID);
        }

        if (userDetails.getCreatedAd() != null) {
            throw new Exception(UserExceptions.UPDATE_BY_ID_EXCEPTION
                    + UserExceptions.UPDATE_NOT_DATE_OF_CREATE);
        }

        if(userDetails.getUpdatedAt() != null) {
            throw new Exception(UserExceptions.UPDATE_BY_ID_EXCEPTION
                    + UserExceptions.UPDATE_NOT_DATE_OF_UPDATE);
        }

        return ResponseEntity.ok(userRepository.save(user));

    }

    public Map<String, Boolean> deleteUserById(Long id) throws Exception {

        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException(UserExceptions.DELETE_BY_ID_EXCEPTION + UserExceptions.USER_NOT_FOUND)
        );

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

    public void deleteAllUsers() throws Exception {
        try {
            userRepository.deleteAll();
        } catch (Exception e) {
            throw new Exception(UserExceptions.DELETE_ALL_USERS_EXCEPTION);
        }
    }

    private boolean isContainsEmail(String email) {
        if (email.contains("@")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidUserName(String userName) {
        if (userName.trim().length() >= 3) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidGender(String gender) throws Exception {
        String trimGender = gender.trim();
        if (trimGender.length() == 1) {
            if (trimGender.contains("E") == false && trimGender.contains("K") == false) {
                throw new Exception(UserExceptions.INVALID_GENDER_CHARACTER);
            } else {
                return true;
            }
        } else {
            throw new Exception(UserExceptions.INVALID_GENDER_CHARACTER_LENGTH);
        }
    }

    private boolean isValidAge(Integer age) throws Exception {
        if (age < 0 || age > 100) {
            throw new Exception(UserExceptions.INVALID_AGE);
        } else {
            return true;
        }
    }
}
