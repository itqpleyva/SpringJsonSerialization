package Main.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Dog {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String raza;
	private String name;
	
	

	public Dog(Integer id, String raza, String name) {
		super();
		this.id = id;
		this.raza = raza;
		this.name = name;
	}
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dog [id=" + id + ", raza=" + raza + ", name=" + name + "]";
	}
	
	
}
