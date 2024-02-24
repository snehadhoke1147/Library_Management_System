package net.javaguides.lms.service;

import java.util.List;

import net.javaguides.lms.model.User;

public interface UserService 
{
	User saveUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(long id);
	
	User updateUser(long id, User user);
	
	void deleteUser(long id);
}
