package top.robotman.luggage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class LuggageApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuggageApplication.class, args);
    }

}
