package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
	
	private static final Logger log = LoggerFactory.getLogger(UserInfo.class);

    private final String name;
    private final Integer age;
    
    @JsonCreator
	public UserInfo(@JsonProperty("name") String name, @JsonProperty("age")Integer age) {
    	log.info("Creating user " + name + ". age: " + age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}