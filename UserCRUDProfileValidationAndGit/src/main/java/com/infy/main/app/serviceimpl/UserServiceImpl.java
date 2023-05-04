package com.infy.main.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.main.app.exception.ContatctNotValidException;
import com.infy.main.app.exception.DataNotFoundInDataBase;
import com.infy.main.app.exception.EmailIdNotValidException;
import com.infy.main.app.exception.FirstnameNotValidException;
import com.infy.main.app.exception.LastnameNotValidException;
import com.infy.main.app.exception.PassWordNotValidException;
import com.infy.main.app.exception.UserNameNotValidException;
import com.infy.main.app.model.User;
import com.infy.main.app.repositry.UserRepositry;
import com.infy.main.app.servicei.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepositry userrepositry;

	@Override
	public User addUser(User user) {
		 String unandpassvalidation = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{10,}$";
			String fistandlastnamevalidtion="^[A-Z].*";	
		 
		 
		 if(!user.getUsername().matches(unandpassvalidation)) {
			 
			 throw new UserNameNotValidException("UserName Not Valid"); 
			 
		 }
		  if(!user.getPassword().matches(unandpassvalidation)) {
			 
			  throw new PassWordNotValidException("Password is Not Valid"); 
		 }
		  
		  if(!user.getFirstname().matches(fistandlastnamevalidtion))
		  {
			  
			  throw new FirstnameNotValidException("Firstname is Not Valid Firstname Started With Alwys Uppercase");
		  }
		  if(!user.getLastname().matches(fistandlastnamevalidtion)) {
			  
			  throw new LastnameNotValidException("Lastname is Not Valid; Lastname Started With Alwys Uppercase");
		  }
		  if(!user.getEmailaddress().endsWith("@gmail.com")) {
			  
			  throw new EmailIdNotValidException("Email Does Not End With @gmail.com");
			  
		  }
		  
		  if(!user.getContactno().toString().matches("^[7-9]\\d{9}$")) {
			throw new ContatctNotValidException("Conatct Does Not Valid;Conatct No Starts must be greater Than 6 and having 10 characher in it");  
			  
		  }
		  
		  
		 else {
			
			 User us=userrepositry.save(user);
			 return us;
			 
		 }
		
		
		 
		 
	}

	@Override
	public List<User> getalluser() {
		List<User> findAll = userrepositry.findAll();
		
		if(findAll.isEmpty()) {
			
			throw new DataNotFoundInDataBase("Data Is Not Present In Database");
			
		}
		else{	
				return findAll;
		}
	}
	

}
