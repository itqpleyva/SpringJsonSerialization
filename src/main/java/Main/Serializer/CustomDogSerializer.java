package Main.Serializer;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import Main.Model.Dog;

public class CustomDogSerializer extends StdSerializer<Dog> {

    public CustomDogSerializer() {
        this(null);
    }
 
    public CustomDogSerializer(Class<Dog> t) {
        super(t);
    }
	@Override
	public void serialize(Dog dog, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {

	        jsonGenerator.writeStartObject();
	        jsonGenerator.writeStringField("dog_raza", dog.getRaza());
	        jsonGenerator.writeEndObject();
		    
	}       
}
