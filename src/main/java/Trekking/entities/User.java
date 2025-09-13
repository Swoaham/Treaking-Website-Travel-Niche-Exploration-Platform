package Trekking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "app_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    private Long phone;
    private String age;
    private String gender;
    private String lvl;
    private String email;
    private double budget;
    private String address;
    
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(Long id, String name, Long phone, String age, String gender, String lvl, String email, double budget,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.lvl = lvl;
		this.email = email;
		this.budget = budget;
		this.address = address;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public String getLvl() {
		return lvl;
	}


	public void setLvl(String lvl) {
		this.lvl = lvl;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getBudget() {
		return budget;
	}


	public void setBudget(double budget) {
		this.budget = budget;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", age=" + age + ", gender=" + gender
				+ ", lvl=" + lvl + ", email=" + email + ", budget=" + budget + ", address=" + address + "]";
	}
    
    

}
