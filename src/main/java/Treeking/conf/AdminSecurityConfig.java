// package Treeking.conf;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import Trekking.Service.TrekkingServiceIMPL;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class AdminSecurityConfig{
//	
////	private UserDetailsService 	
//	
//	
//	@Bean
//	public UserDetailsService getUserDetailsService() {
//		return new TrekkingServiceIMPL();
//		
//	}
//	
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
//    }
//    
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//    	DaoAuthenticationProvider DAP = new DaoAuthenticationProvider();
//    	DAP.setUserDetailsService(this.getUserDetailsService());
//    	DAP.setPasswordEncoder(passwordEncoder());
//    	
//    	return DAP;
//    }
//
//	
//    
////    configure method
//    
//    @Bean
//    public AuthenticationManager authManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//    
//    
//    
//  
//  
//  
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////            .authorizeRequests()
////                .antMatchers("/public/**").permitAll() // Allow public access to certain endpoints
////                .anyRequest().authenticated() // All other requests require authentication
////                .and()
////            .formLogin() // Enable form-based login
////                .permitAll() // Allow everyone to see the login page
////                .and()
////            .logout() // Enable logout
////                .permitAll(); // Allow everyone to log out
////
////        return http.build();
////    }
//    
//    
//    
//    
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/treks/**").permitAll() // Allow all requests under /treks/
//                .requestMatchers("/treks/admin/adminlogin").permitAll() // Allow access to the login page
//                .requestMatchers("/treks/admin/**").hasRole("MANAGER") // Only allow access to /treks/admin/** for users with the MANAGER role
//                .anyRequest().authenticated() // Require authentication for all other requests
//            )
//            .formLogin(form -> form
//                .loginPage("/treks/admin/adminlogin") // Custom login page
//                .defaultSuccessUrl("/treks/admin/") // Redirect after successful login
//                .permitAll() // Allow everyone to see the login page
//            )
//            .logout(logout -> logout
//                .logoutSuccessUrl("/treks/admin/adminlogin") // Redirect after logout
//                .permitAll() // Allow everyone to logout
//            )
//            .rememberMe(rememberMe -> rememberMe
//                .key("uniqueAndSecret") // Key for remember-me functionality
//                .tokenValiditySeconds(86400) // Token validity for 1 day
//            )
//            .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
//    
//}