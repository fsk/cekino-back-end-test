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
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException(UserExceptions.USER_NOT_FOUND));
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            throw new Exception(UserExceptions.USER_GET_BY_ID_EXCEPTION);
        }
    }


    public User insertUser(User user) throws Exception {
        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime date = LocalDateTime.now();

//            User userByEmail = userRepository.findByUserName(user.getEmail());
//            User userByUserName = userRepository.findByUserName(user.getUserName());

            if (user.getName() == null || user.getName().equals("")
                    && user.getSurname() == null || user.getSurname().equals("")
                    && user.getUserName() == null || user.getUserName().equals("")
                    && user.getEmail() == null || user.getEmail().equals("")) {
                throw new IllegalArgumentException(UserExceptions.COMPULSORY_FIELDS_EXCEPTION + UserExceptions.COMPULSORY_FIELDS);
            }

//            if (userByEmail != null) {
//                throw new IllegalArgumentException(UserExceptions.EMAIL_ALREADY_EXISTS);
//            } else if (!user.getEmail().contains("@")) {
//                throw new IllegalArgumentException(UserExceptions.INVALID_EMAIL);
//            }
//
//            if (userByUserName != null) {
//                throw new IllegalArgumentException(UserExceptions.USER_NAME_ALREADY_EXISTS);
//            } else if (user.getUserName().trim().length() < 3) {
//                throw new IllegalArgumentException(UserExceptions.MIN_CHARACTER_EXCEPTION);
//            }

            if (user.getIdentityNumber().trim().length() != 11) {
                throw new SQLException(UserExceptions.IDENTITY_NUMBER_EXCEPTION);
            }

            if (user.getGender().trim().length() != 1) {
                throw new SQLException(UserExceptions.GENDER_EXCEPTION);
            }

            user.setCreatedAd(date.format(formatter));

            return userRepository.save(user);

        } catch (Exception e) {
            throw new Exception(UserExceptions.INSERT_EXCEPTION + e.getMessage());
        }
    }


    public ResponseEntity<User> updateUserById(Long id, User userDetails) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        try {
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
                user.setAge(userDetails.getAge());
            }

            if (userDetails.getUserName() != null) {
                user.setUserName(userDetails.getUserName());
            }

            if (userDetails.getEmail() != null) {
                user.setEmail(userDetails.getEmail());
            }

            if (userDetails.getGender() != null) {
                user.setGender(userDetails.getGender());
            }

            user.setUpdatedAt(date.format(formatter));

            if (userDetails.getIdentityNumber() != null) {
                throw new Exception(UserExceptions.UPDATE_NOT_IDENTITY_NUMBER);
            }

            if (userDetails.getId() != null) {
                throw new Exception(UserExceptions.UPDATE_NOT_ID);
            }

            if (userDetails.getCreatedAd() != null) {
                throw new Exception(UserExceptions.UPDATE_NOT_DATE_OF_CREATE);
            }

            return ResponseEntity.ok(userRepository.save(user));

        } catch (Exception e) {
            throw new Exception(UserExceptions.UPDATE_BY_ID_EXCEPTION);
        }
    }

    public Map<String, Boolean> deleteUserById(Long id) throws Exception {
        try {
            User user = userRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException(UserExceptions.USER_NOT_FOUND)
            );

            userRepository.delete(user);
            Map<String, Boolean> response = new HashMap<>();
            response.put("DELETED", Boolean.TRUE);
            return response;

        } catch (Exception e) {
            throw new Exception(UserExceptions.DELETE_BY_ID_EXCEPTION);
        }
    }


    public void deleteAllUsers() throws Exception {
        try {
            userRepository.deleteAll();
        } catch (Exception e) {
            throw new Exception(UserExceptions.DELETE_ALL_USERS_EXCEPTION);
        }
    }
}


