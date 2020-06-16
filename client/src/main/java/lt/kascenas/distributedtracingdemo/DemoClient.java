package lt.kascenas.distributedtracingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import java.util.Random;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoClient implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String[] args) {
        Random random = new Random();
        int time = 1 + random.nextInt(2);
        restTemplate.getForEntity("http://localhost:8081/hello?time=" + time, String.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(DemoClient.class, args);
    }

}
