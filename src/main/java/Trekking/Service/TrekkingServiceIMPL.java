package Trekking.Service;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import Treeking.conf.CustomUserDetails;
import Trekking.DAO.AdminDAO;
import Trekking.DAO.TrekkingDAO;
import Trekking.DAO.UserDAO;
import Trekking.entities.Admin;
import Trekking.entities.Trekking;
import Trekking.entities.User;

@Service
public class TrekkingServiceIMPL  implements TrekkingService{
	
	
	@Autowired
    private TrekkingDAO ts;  
	
	@Autowired
    private UserDAO us;		
	
	@Autowired
	private AdminDAO as;
	
//	 @Autowired
//	private BCryptPasswordEncoder passwordEncoder;

	
	
	
	
	
	// Define the directory where files will be saved (e.g., "uploads" folder in the project root)
//	private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";
	

	// Make sure the directory exists
//    static {
//    	try {
//            Files.createDirectories(Paths.get(UPLOAD_DIR));
//        } catch (IOException e) {
//            throw new RuntimeException("Could not create upload directory: " + e.getMessage());
//        }
//    	
//        }
    	
    
//	FOR TREKS
	
    // Get all trekking packages
    @Override
    public List<Trekking> getAllTreks() {
        return ts.findAll(); // Retrieves all trekking packages
    }

    // Get a single trekking package by its ID
    @Override
    public Trekking getTrekkingById(Long id) {
    	
    	
//    	Trekking trekking = ts.findById(id)
//                .orElseThrow(() -> new RuntimeException("Trekking package not found with id " + id));
//            // Initialize images if lazy-loaded
//            trekking.getImages().size(); // Trigger loading
//            return trekking;
    	
    	return ts.findById(id).orElseThrow(() -> new RuntimeException("Trekking package not found with id " + id));
    	 
//        Optional<Trekking> optionalTrekking = ts.findById(id);
//        return optionalTrekking.orElseThrow(() -> new RuntimeException("Trekking package not found with id " + id));
    }

    // Save or update a trekking package
    @Override
    public void saveTrekking(Trekking trekking) {
        ts.save(trekking); // Save the trekking package (if ID is null, it's an insert; otherwise, it's an update)
    }

    // Delete a trekking package by its ID
    @Override
    public void deleteTrekking(Long id) {
        ts.deleteById(id); // Deletes a trekking package by its ID
    }

    
//    FOR USER
    
    @Override
    public List<User> getAllUsers() {
        return us.findAll(); // Retrieves all trekking packages
    }
    
    @Override
    public void saveUser(User user) {
        us.save(user); // Save the user (if ID is null, it's an insert; otherwise, it's an update)
    }

 // Delete a trekking package by its ID
	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		us.deleteById(id);
	}

	
//	for search
	@Override
	public List<Trekking> searchTreks(String query) {
		 // Implement the search logic here
        // For example, you might want to search by name or description
        return ts.findByNameContainingIgnoreCase(query);
    
	}

	
//	////for admin login using email

//@Override
//public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	// How to fetch admin from data base
//	
//	
//	Admin admin = as.getEmail(username);
//	if(admin == null) {
//		throw new UsernameNotFoundException("USER does not exist!!!");
//	}
//	
//	CustomUserDetails CUD = new CustomUserDetails(admin);
//	
//	return CUD;
//}


//	 To save manager data
//		@Override
//		public void saveManager(Admin Manager,String username, String rawPassword) {
//			String encodedPassword = passwordEncoder.encode(rawPassword);
//			Manager.setPassword(encodedPassword);  // Set the encoded password
//			as.save(Manager);
//			
//		}
		
//		to change manager password
//		@Override
//	    public Admin getManagerinfo(Long id){
//			return as.findById(id).orElseThrow(() -> new RuntimeException("Manager not found with id " + id));
//		}
		

		
	
////for admin login using email
//	@Override
//    public UserDetails loadUser getEmail(String email) throws UsernameNotFoundException {
//        Admin admin = as.findByEmail(email);
//        if (admin == null) {
//            throw new UsernameNotFoundException("User  not found with email: " + email);
//        }
//        return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(), new ArrayList<>());
//    }
	
////	for admin login using email
//    @Override
//    public UserDetails getEmail(String email) throws UsernameNotFoundException {
//    	
//        Admin admin = as.findByEmail(email);
//        if (admin == null) {
////        	model.addAttribute("error", "Invalid email or password.");
////            return "adminlogin"; // Return to the login page
//            throw new UsernameNotFoundException("NO USER found with the given email");
//            
//        }
//        return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(), new ArrayList<>());
//    }
//
//	@Override
//	public UserDetails getPassword(String password) throws UsernameNotFoundException {
//    	
//        Admin admin = as.findByPassword(password);
//        if (admin == null) {
//        	
//            throw new UsernameNotFoundException("The password for the given email is INVALID");
//            
//        }
//        return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(), new ArrayList<>());
//    }

	

	
	
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
    
////	when creating a new user, hash the password before saving it.
//	public void registerUser (User user) {
//	    String encodedPassword = passwordEncoder().encode(user.getPassword());
//	    user.setPassword(encodedPassword);
//	    userRepository.save(user);
//	}
	
    
// for image
	
//	public String uploadFile(MultipartFile file) throws IOException {
//	    
//	   
//
//	    // Get the original filename
//	    String originalFilename = file.getOriginalFilename();
//	    if (originalFilename == null || originalFilename.isEmpty()) {
//	        throw new RuntimeException("Failed to retrieve file name.");
//	    }
//
//	    // Define the file path where the file will be saved
//	    Path targetLocation = Paths.get(UPLOAD_DIR + originalFilename);
//	    	
//	    // Save the file to the target location
//	    Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//
//	   
//	    // Return the file path or URL for later use (e.g., storing it in the database)
////	    return targetLocation.toString(); // Or you could return a relative URL depending on your use case
//	    return "/uploads/" + originalFilename; 
//	    
//	}

    
    
    

//	 @Autowired
//	    public TrekkingServiceIMPL(TrekkingDAO trekkingDAO) {
//	        this.ts = trekkingDAO;
//	    }
	 
	 
//	@Override
//    public List<Trekking> getAllUsers() {
//        return ts.findAll();  // Fetching all records from the database
//    } 
	
//	@Override
//    public Iterable<Trekking> getAllUsers() {
//        return ts.findAll();  // Fetching all records from the database
//    } 


}
