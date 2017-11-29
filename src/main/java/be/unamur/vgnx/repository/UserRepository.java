package be.unamur.vgnx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.unamur.vgnx.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
