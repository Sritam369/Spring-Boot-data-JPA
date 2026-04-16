package com.sri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.User;
import com.sri.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public String addUser(User user) {
		return "user saved with id : "+repo.save(user).getId();
	}
	
	public List<User> viewUser() {
		return repo.findAll();
	}
	
	public String updateUser(Long id,String name,String phone) {
		if(repo.findById(id).isEmpty()) {
			return "user not found";
		}
		else {
			Optional<User> byId = repo.findById(id);
			User user = byId.get();
			user.setName(name);
			user.getProfiles().setPhone(phone);
			User save = repo.save(user);
			if(save!=null) {
				return "user updated";
			}
			else {
				return "user not updated";
			}
		}
	}
	
	public String deleteUser(Long id) {
		if(repo.findById(id).isEmpty()) {
			return "user not deleted";
		}
		else {
			repo.deleteById(id);
			return "user deleted";
		}
	}
	
}
