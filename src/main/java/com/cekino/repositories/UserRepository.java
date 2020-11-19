package com.cekino.repositories;

import com.cekino.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
     User findByEmail(String email);
     User findUserByUserName(String userName);
     User findByUserName(String userName);
}
