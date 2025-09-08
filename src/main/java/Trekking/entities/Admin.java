package Trekking.entities;



import java.util.Collection;

//import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 40)
    private String name;
    
    @Column(nullable = false, unique = true, length = 10)
    private Long phone;
    
    @Column(nullable = false, length = 10)
    private String age;
    
    @Column(nullable = false, length = 10)
    private String gender;

    @Column(nullable = false, unique = true, length = 40)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;
    
    @Column(nullable = false, length = 10)
    private String role;
    
    @Column(nullable = false, unique = true, length = 40)
    private String address;

    

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Admin(Integer id, String name, Long phone, String age, String gender, String email, String password,
			String role, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.role = role;
		this.address = address;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Long getPhone() {
		return phone;
	}



	public void setPhone(Long phone) {
		this.phone = phone;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}






	

	
    
}