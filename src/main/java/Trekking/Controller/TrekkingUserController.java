package Trekking.Controller;

import Trekking.entities.Trekking;
import Trekking.entities.User;
import Trekking.Service.TrekkingService;
import Trekking.Service.TrekkingServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/treks")
public class TrekkingUserController {

    @Autowired
    private TrekkingService trekkingService;
   

    // Show all trekking packages for users
//    @GetMapping("/")
//    @ResponseBody
//    public String mydata()
//    {
//    	return "Hello hiii";
//    }
    
//    @GetMapping("/search")
//    public String search(@RequestParam(name = "query", required = false) String query, Model model) {
//        List<Item> items = trekkingService.searchItems(query);
//        model.addAttribute("items", items);
//        model.addAttribute("query", query);
//        return "search"; // This should match your Thymeleaf template name
//    }
//    
//    @GetMapping("/search")
//    public String getCards(@RequestParam(required = false) String search, Model model) {
//        List<Card> cards;
//        if (search != null && !search.isEmpty()) {
//            cards = trekkingService.searchCards(search);
//        } else {
//            cards = trekkingService.getAllCards();
//        }
//        model.addAttribute("cards", cards);
//        model.addAttribute("search", search);
//        return "cards"; // This should match your Thymeleaf template name
//    }
    
    @GetMapping("/search")
    @ResponseBody // This annotation tells Spring to return the response as JSON
    public Iterable<Trekking> search(@RequestParam(name = "query", required = false) String query) {
        if (query == null || query.trim().isEmpty()) {
            return trekkingService.getAllTreks(); // Assuming this method returns all trekking packages
        }
        return trekkingService.searchTreks(query);
    }
    
     @GetMapping("/")
     public String showAllTreks(Model model) {
    	System.out.println("Cards count = " + trekkingService.getAllTreks().size());
        model.addAttribute("cards",  trekkingService.getAllTreks());
        return "project-1"; // Return the list of trekking packages to the user
    }
     
     @GetMapping("/Register")
     public String sign_in(Model m) {
    	 m.addAttribute("trek", new User());
         return "sign_in_page";
     }
          	
     
     @PostMapping("/save")
     public String saveuser(@ModelAttribute User trek) {
     	
         trekkingService.saveUser(trek);
        
         return "redirect:/treks/"; // Redirect to the list of trekking packages after save
     }
     
  // Handle image upload along with text input (titles and descriptions)
//     @PostMapping("/save")
//     public String saveuser(
//         @RequestParam("images") MultipartFile[] files,
//         @RequestParam("titles") String[] titles,
//         @RequestParam("descriptions") String[] descriptions,
//         Model model) throws IOException {
//         
//         // List to store image paths and their associated titles and descriptions
//         List<ImageWithDetails> imageList = new ArrayList<>();
//
//         // Loop through the uploaded files and save them
//         for (int i = 0; i < files.length; i++) {
//             MultipartFile file = files[i];
//             if (!file.isEmpty()) {
//                 // Generate a unique filename for each image
//                 String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//                 Path path = Paths.get(UPLOAD_DIR + fileName);
//                 Files.copy(file.getInputStream(), path);
//
//                 // Get the title and description for the current image
//                 String title = (i < titles.length) ? titles[i] : "Untitled";
//                 String description = (i < descriptions.length) ? descriptions[i] : "No description provided";
//
//                 // Add image path, title, and description to the list
//                 imageList.add(new ImageWithDetails("/uploads/" + fileName, title, description));
//             }
//         }
//
//         // Add the list of images to the model
//         model.addAttribute("imageList", imageList);
//         return "carouselPage";  // Redirect to the carousel page to display images with details
//     }

     
     @GetMapping("/guide")
     public String guide() {
         return "guide";
     }
     
     @GetMapping("/safety")
     public String safety() {
         return "safety";
     }
     
     @GetMapping("/aboutus")
     public String aboutus() {
         return "aboutus";
     }
     
     @GetMapping("/admin")
     public String admin() {
         return "admin";
     }


////     Show details of a specific trekking package
    @GetMapping("/{id}")
    public String showTrekkingDetails(@PathVariable Long id, Model model) {
        Trekking trekking = trekkingService.getTrekkingById(id);
        if (trekking != null) {
            model.addAttribute("cards", trekking);
            return "uttarakhand"; // Ensure this view exists
        } else {
            model.addAttribute("errorMessage", "Trekking package not found");
            return "error"; // Ensure this view exists
        }
        }

//    // Handle requests from the user (e.g., booking or contacting for more info)
    @PostMapping("/request-info")
    public String requestInfo(@RequestParam Long trekId, @RequestParam String email, Model model) {
        // Handle user request (for example, send email or save request)
        return "redirect:/treks"; // Redirect to the list of trekking packages
    }
    
    
}
