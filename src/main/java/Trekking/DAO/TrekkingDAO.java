package Trekking.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Trekking.entities.Trekking;
import Trekking.entities.User;

@Repository
public interface TrekkingDAO extends JpaRepository<Trekking, Long>{

	List<Trekking> findByNameContainingIgnoreCase(String query);
	
	

}

