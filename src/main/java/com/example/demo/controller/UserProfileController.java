package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserProfile;

@RestController 
public class UserProfileController {
	
	public Map<String,UserProfile> userMap;
	
	@PostConstruct
	public void init() {
		userMap = new HashMap<String,UserProfile>();
		userMap.put("1", new UserProfile("1","홍길동","111-1111","대전 대덕구"));
		userMap.put("2", new UserProfile("1","김기기","111-1111","대전 대덕구"));
		userMap.put("3", new UserProfile("1","박바바","111-1111","대전 대덕구"));		
	}
	
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return userMap.get(id);
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList(){
		return new ArrayList<UserProfile>(userMap.values()); 
	}	
	
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone ,  @RequestParam("address") String address) {
		UserProfile userprofile = new UserProfile(address, name, phone, address);
		userMap.put(id,userprofile);
	}	
	
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone ,  @RequestParam("address") String address) {
		UserProfile userProfile = userMap.get(id);
		userProfile.setName(name);
		userProfile.setName(phone);
		userProfile.setName(address);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		userMap.remove(id);
	}
}
