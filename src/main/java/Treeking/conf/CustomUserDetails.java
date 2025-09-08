//package Treeking.conf;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import Trekking.DAO.AdminDAO;
//import Trekking.entities.Admin;
//
//
//@Service
//public class CustomUserDetails implements UserDetailsService{
//
//	
//	@Autowired
//	private AdminDAO admindao;
//	
//	
//
////	@Override
////	public Collection<? extends GrantedAuthority> getAuthorities() {
////
////
////		SimpleGrantedAuthority SGA = new SimpleGrantedAuthority(admin.getRole());
////		return List.of(SGA);
////	}
////
////	@Override
////	public String getPassword() {
////		// TODO Auto-generated method stub
////		return admin.getPassword();
////	}
////
////	@Override
////	public String getUsername() {
////		// TODO Auto-generated method stub
////		return admin.getEmail();
////	}
//
//
//
//	/**
//	 *
//	 */
//	 @Override
//	    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
//	        Admin admin = admindao.findbyUsernameorEmail(usernameOrEmail, usernameOrEmail)
//	                .orElseThrow(() -> new UsernameNotFoundException("User  does not exist by username or email"));
//
//	        Set<GrantedAuthority> authorities = admin.getRole().stream()
//	                .map(role -> new SimpleGrantedAuthority(role.getName()))
//	                .collect(Collectors.toSet());
//
//	        return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(), authorities);
//	    }
//		
//	
//
//}
