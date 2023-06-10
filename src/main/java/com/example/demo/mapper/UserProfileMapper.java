package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserProfile;

@Mapper
public interface UserProfileMapper {
	@Select("SELECT * FROM userprofile WHERE id=#{id}")
	UserProfile getUserProfile(@Param("id") String id); 
	
	@Select("SELECT * FROM userprofile")
	List<UserProfile> getUserProfileList();
	
	@Insert("INSERT INTO userprofile VALUES(#{id}, #{name}, #{phone}, #{address})")
	int putUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone ,  @Param("address") String address);
	
	@Update("UPDATE userprofile SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
	int postUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone ,  @Param("address") String address);
	
	@Delete("DELETE FROM userprofile WHERE #{id}")
	int deleteUserProfile(@Param("id") String id);
}
