package net.javaguides.lms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.lms.exception.ResourceNotFoundException;
import net.javaguides.lms.model.User;
import net.javaguides.lms.repository.UserRepository;
import net.javaguides.lms.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		 return userRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("User", "Id", id));
	}

	@Override
	public User updateUser(long id, User user) {
		// TODO Auto-generated method stub
		// we need to check whether user with given id is exist in DB or not
		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "Id", id)); 
		
		existingUser.setUserName(user.getUserName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());

		// save existing user to DB
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		// check whether a user exist in a DB or not
				userRepository.findById(id).orElseThrow(() -> 
										new ResourceNotFoundException("User", "Id", id));
				userRepository.deleteById(id);
			}
	

}


	

