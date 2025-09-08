package Trekking.Controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Trekking.Service.TrekkingService;
import Trekking.entities.Admin;
//import Trekking.entities.Image;
import Trekking.entities.Trekking;



@Controller
@RequestMapping("/treks/admin")
public class TrekkingController {

//    private static final PrintStream card = null;
	@Autowired
    private TrekkingService trekkingService;
	
	
//	@Autowired
//    private BCryptPasswordEncoder passwordEncoder; 
	
	
//	private PrintStream cards;
    
//    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";
    

    // Show all trekking packages for users
//  @GetMapping("/")
//  @ResponseBody
//  public String mydata()
//  {
//  	return "Hello hiii";
//  }
    
    // Show all trekking packages for admin
    @GetMapping("/adminlogin")
    public String showAllTreks() {
   
        return "agentlogin"; // Returns the view for adminlogin
    }
    

    // Show form to create a new trekking package
    @GetMapping("/")
    public String AdminshowAllTreks(Model model) {
//    	try {
//    	model.addAttribute("card",  trekkingService.getEmail(email));
//    	model.addAttribute("card",  trekkingService.getPassword(password));
    	
        model.addAttribute("cards",  trekkingService.getAllTreks());
     
        return "admin"; // Return form to create a new trekking package
        
//    	} catch (UsernameNotFoundException e) {
//    		model.addAttribute("error", "Invalid email or password.");
//            return "/adminlogin"; // Return to the login page
//        }
    	
    }
    
    @GetMapping("/adminadd")
    public String adminadd(Model model) {
    	model.addAttribute("card", new Trekking());
        return "adminadd";
    }
    
    @GetMapping("/AddNewAdmin")
    public String AddNewAdmin() {
        return "AddNewAdmin";
    }
    
    
    // Save or update Manager
//    @PostMapping("/saveManager")
//    public String saveManage(@ModelAttribute Admin manager, String username, String rawPassword) {
//    	System.out.println("Before saving Manager data");
//        trekkingService.saveManager(manager , username, rawPassword);
//        System.out.println("After saving Manager data");
//        return "redirect:/treks/admin/"; // Redirect to the list of trekking packages after save
//    }
    
 // change password
    @GetMapping("/changepassword")
    public String changePassword() {
        return "AdminChangePassword";
    }
    
 // POST method to handle the password change
//    @PostMapping("/updatepassword")
//    public String updatePassword(@RequestParam Long id,
//                                  @RequestParam String currentPassword,
//                                  @RequestParam String newPassword,
//                                  @RequestParam String confirmPassword, String username, String rawPassword,
//                                  Model model) {
//        Admin manager = trekkingService.getManagerinfo(id);
//        if (manager != null) {
//            // Check if the current password matches
//            if (passwordEncoder.matches(currentPassword, manager.getPassword())) {
//                // Check if new password and confirm password match
//                if (newPassword.equals(confirmPassword)) {
//                    // Encode the new password and update the manager
//                    manager.setPassword(passwordEncoder.encode(newPassword));
//                    trekkingService.saveManager(manager , username, rawPassword); // Save the updated manager
//                    model.addAttribute("successMessage", "Password changed successfully!");
//                } else {
//                    model.addAttribute("errorMessage", "New password and confirm password do not match.");
//                }
//            } else {
//                model.addAttribute("errorMessage", "Current password is incorrect.");
//            }
//        }
//        return "redirect:/treks/admin/"; // Return to the password change form
//    }
    
    
    @GetMapping("/edit/{id}")
    public String update(@PathVariable Long id, Model m) {
    	Trekking card = trekkingService.getTrekkingById(id);
    	if(card != null) {
        m.addAttribute("card", card);
        return "adminupdate";
    	}
    	return "redirect:/treks/admin";
    }
    
    
    @PostMapping("/trekupdate/{id}")
    public String admintrekupdate(@PathVariable Long id, @ModelAttribute Trekking m) {
    	m.setId(id);
		trekkingService.saveTrekking(m);
        return "redirect:/treks/admin/";
    }
    
    @GetMapping("/userinfo")
    public String userinfo(Model model) {
    	model.addAttribute("trekList",  trekkingService.getAllUsers());
        return "viewuserdata";
    }
    

    
   
    // Save or update trekking package
    @PostMapping("/save")
    public String saveTrekking(@ModelAttribute Trekking card) {
    	System.out.println("Before saving Trek data");
        trekkingService.saveTrekking(card);
        System.out.println("After saving Trek data");
        return "redirect:/treks/admin/?success"; // Redirect to the list of trekking packages after save
    }
    


    
//    @PostMapping("/save")
//    public String saveTrekking(@Validated @ModelAttribute Trekking card,
//                               @RequestParam("images") MultipartFile[] files, BindingResult result) {
//    	
//    	System.out.println("Saving trekking: " + card);
//        List<Image> images = new ArrayList<>();
//        
//        for (MultipartFile file : files) {
//        	 try {
//                 // Create the upload directory if it doesn't exist
//                 File uploadDir = new File(UPLOAD_DIR);
//                 if (!uploadDir.exists()) {
//                     uploadDir.mkdirs(); // Create the directory
//                 }
//
//                 // Save the file to the specified path
//                 String imagePath = UPLOAD_DIR + file.getOriginalFilename();
//                 file.transferTo(new File(imagePath)); // Save the file
//
//                 // Create an Image entity and add it to the list
//                 images.add(new Image(imagePath)); // Create an Image entity
//             } catch (IOException e) {
//                 // Handle the exception (e.g., log it and show an error message)
//                 e.printStackTrace();
//             }
//        }
//        
//        card.setImages(images); // Set the images in the trekking entity
//        trekkingService.saveTrekking(card); // Save the trekking entity
//        return "redirect:/treks/admin/"; // Redirect after saving
//    
        
//        try {
//            // Check if the file is empty
//            if (images == null || images.length == 0) {
//                throw new RuntimeException("No file uploaded");
//            }
//         // created List to store the image file paths
//            List<String> imagePaths = new ArrayList<>();
//            
//         // Process each uploaded file
//            for (MultipartFile imageFile : images) {
//                if (!imageFile.isEmpty()) {
//                    // Save the file and get its path
//                	
//                    String imagePath = trekkingService.uploadFile(imageFile);
//                    imagePaths.add(new String(imagePath));
////                    imagePaths.add(imagePath);  // Add the file path to the list
//                    
//                }
//            }
//            // Set the image URL/path in the Trekking entity
//            card.setImages(imagePaths);
//            
//         // Save the Trekking entity to the database (using JPA)
//            trekkingService.saveTrekking(card);
//
//            return "redirect:/treks/admin/";
//        } catch (Exception e) {
//            return "Error saving trekking: " + e.getMessage();
//        }
//    }



	// Show form to edit a trekking package
//    @PostMapping("/edit/{id}")
//    public String update(@PathVariable Long id, Model model) {
//
//    	
//        Trekking trekking = trekkingService.getTrekkingById(id);
//        if (trekking == null) {
//            // Handle the case where the user is not found
//        	return "redirect:/admin/";  // Or an appropriate error page
//        }
//        model.addAttribute("card", new Trekking());
//        model.addAttribute("cards",  trekkingService.getAllTreks());
//        
//        return "redirect:/admin/"; // Return form to edit a trekking package
//    }
    


	// Delete a trekking package
    @GetMapping("/delete/{id}")
    public String deleteTrekking(@PathVariable Long id) {
        trekkingService.deleteTrekking(id);
        return "redirect:/treks/admin/"; // Redirect to the list of trekking packages after delete
    }
    
 // Delete a User data
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        trekkingService.deleteUser(id);
        return "redirect:/treks/admin/userinfo"; // Redirect to the list of trekking packages after delete
    }
}


