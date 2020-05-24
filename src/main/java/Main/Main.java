package Main;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import Main.Model.Dog;
import Main.Serializer.CustomDogSerializer;

@SpringBootApplication
public class Main implements CommandLineRunner {

	public static void main(String[] args) {
		
		SpringApplication.run(Main.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper(); // creating object mapper instance
		
		Dog dog = new Dog(1,"puddle", "Negrito");//creating new dog
		
		objectMapper.writeValue(new File("target/dog.json"), dog); // saving dos as json in dog.json file
		
		String doggie = objectMapper.writeValueAsString(dog);// generatin json string
		
		System.out.println("Get Dog json from Dog instance ----------- "+doggie);
		
		String json = "{\"id\" : 1, \"raza\" : \"puddle\", \"name\" : \"Negrito\" }"; // creating a json
		
		Dog dog1 = objectMapper.readValue(json, Dog.class); // turning json into a Dog instance
		
		Dog dog2 = objectMapper.readValue(new File("target/dog.json"), Dog.class); // turnig json from a json file into a Dog instance
		
		System.out.println("Get Dog instace from json -----------"+dog1);
		 
		System.out.println("Get Dog instace from json file ----------- "+dog2);
		
		String json1 = "[{\"id\" : 1, \"raza\" : \"puddle\", \"name\" : \"Negrito\" },{\"id\" : 2, \"raza\" : \"puddle\", \"name\" : \"Negrito\" }]";

		List<Dog> listDog = objectMapper.readValue(json1, new TypeReference<List<Dog>>(){});// turning json into List of dogs
		
		System.out.println("Get Dog list from json ----------- "+listDog);
		
		Map<String, Object> mapDog = objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});// turning json into List of dogs
		
		System.out.println("Get Dog Map from json ----------- "+mapDog);
		
		//using serializer
		
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = 
		  new SimpleModule("CustomDogSerializer", new Version(1, 0, 0, null, null, null));
		module.addSerializer(Dog.class, new CustomDogSerializer());
		mapper.registerModule(module);
		Dog dog3 = new Dog(4,"puddle", "Chucho");
		String dogJson = mapper.writeValueAsString(dog3);
		
		System.out.println("Get dog json from custom serializer:--------------"+dogJson);
	}

}
