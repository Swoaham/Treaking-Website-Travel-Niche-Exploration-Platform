package Trekking.DAO;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Trekking.entities.Admin;
import Trekking.entities.Trekking;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Long> {
//	Admin findByEmail(String email);
//	Admin findByPassword(String password);
	
//	@Query("SELECT a FROM Admin a WHERE a.email = :email")
//	public Admin getEmail(@Param("email") String email);

//	Optional<Admin> findbyUsername(String username);
	
//	Boolean existByEmail(String email);
	
//	Optional<Admin> findbyUsernameorEmail(String username, String email);
	
	
	
	
}
