package distributedtracingdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoServer {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "time", defaultValue = "0") String time) throws InterruptedException {
        Thread.sleep(Integer.parseInt(time) * 1000);
        return "Hello, world!";
    }

}