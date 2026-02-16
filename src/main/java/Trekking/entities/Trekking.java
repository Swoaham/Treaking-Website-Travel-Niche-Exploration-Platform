package Trekking.entities;

import java.util.List;

import jakarta.persistence.*;


@Entity
public class Trekking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    private String duration;
    private double price;
    private double rating;
//    private String link;
//    @ElementCollection
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Image> images;
	@Column(columnDefinition = "TEXT")
    private String image1;
	@Column(columnDefinition = "TEXT")
    private String image2;
	@Column(columnDefinition = "TEXT")
    private String image3;
	@Column(columnDefinition = "TEXT")
    private String image4;
	@Column(columnDefinition = "TEXT")
    private String image5;
	@Column(columnDefinition = "TEXT")
    private String image6;
	@Column(columnDefinition = "TEXT")
    private String description1;
	@Column(columnDefinition = "TEXT")
    private String description2;
    
    
	public Trekking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Trekking(Long id, String name, String duration, double price, double rating, String image1, String image2,
			String image3, String image4, String image5, String image6, String description1, String description2) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.price = price;
		this.rating = rating;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.image6 = image6;
		this.description1 = description1;
		this.description2 = description2;
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


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getImage1() {
		return image1;
	}


	public void setImage1(String image1) {
		this.image1 = image1;
	}


	public String getImage2() {
		return image2;
	}


	public void setImage2(String image2) {
		this.image2 = image2;
	}


	public String getImage3() {
		return image3;
	}


	public void setImage3(String image3) {
		this.image3 = image3;
	}


	public String getImage4() {
		return image4;
	}


	public void setImage4(String image4) {
		this.image4 = image4;
	}


	public String getImage5() {
		return image5;
	}


	public void setImage5(String image5) {
		this.image5 = image5;
	}


	public String getImage6() {
		return image6;
	}


	public void setImage6(String image6) {
		this.image6 = image6;
	}


	public String getDescription1() {
		return description1;
	}


	public void setDescription1(String description1) {
		this.description1 = description1;
	}


	public String getDescription2() {
		return description2;
	}


	public void setDescription2(String description2) {
		this.description2 = description2;
	}


	@Override
	public String toString() {
		return "Trekking [id=" + id + ", name=" + name + ", duration=" + duration + ", price=" + price + ", rating="
				+ rating + ", image1=" + image1 + ", image2=" + image2 + ", image3=" + image3 + ", image4=" + image4
				+ ", image5=" + image5 + ", image6=" + image6 + ", description1=" + description1 + ", description2="
				+ description2 + "]";
	}
	
	

	
	
    
    
    

}
