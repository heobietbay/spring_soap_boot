import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/**
 * This one WILL NOT WORK, be cause its not in any package, thus result in Spring Boot scan everything org.*
 */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}