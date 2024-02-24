package net.javaguides.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.lms.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
