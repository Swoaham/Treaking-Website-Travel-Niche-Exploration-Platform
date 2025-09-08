package Trekking.Service;



import java.io.IOException;
import java.util.List;

//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.web.multipart.MultipartFile;

import Trekking.entities.Trekking;
import Trekking.entities.User;
import Trekking.entities.Admin;


public interface TrekkingService {

//	List<Trekking> getAllUsers();
//	Iterable<Trekking> getAllUsers();

	

    Iterable<Trekking> getAllTreks();

    Trekking getTrekkingById(Long id);

    void saveTrekking(Trekking trekking);

    void deleteTrekking(Long id);

//    for user
	Iterable<User> getAllUsers();
	
	void saveUser(User trek);

	void deleteUser(Long id);

	  // Search for trekking packages based on a query
    List<Trekking> searchTreks(String query);
	
	
	 // Load user details by email for admin login
//    UserDetails getEmail(String email);
//
//    UserDetails getPassword(String password);
    
    
//    for saving the manager
//    void saveManager(Admin Manager,String username, String rawPassword);
    
//    to fetch manager info
//    Admin getManagerinfo(Long id);
    
    
    
    
	 // Load user details by email for admin login
    
//    UserDetails getEmail(String email) throws UsernameNotFoundException;

   
    

}
