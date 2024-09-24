package com.icwd.user.service.UserService.repositories;

import com.icwd.user.service.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>
{

    //basic ones are already added, we can add custom here now
}
