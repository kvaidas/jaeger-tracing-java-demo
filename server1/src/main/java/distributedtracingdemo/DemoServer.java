package distributedtracingdemo;

import distributedtracingdemo.jpa.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoServer {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerRepository repo;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "time", defaultValue = "0") String time) throws InterruptedException {
        Thread.sleep(Integer.parseInt(time) * 1000);
        String demoResourceUrl = "http://localhost:8082/hello?time=" + time;
//        if (true) throw new ArithmeticException("Test exception");
        ResponseEntity<String> response = restTemplate.getForEntity(demoResourceUrl, String.class);
        repo.count();
        Thread.sleep(Integer.parseInt(time) * 1000);
        return response.getBody();
    }

}