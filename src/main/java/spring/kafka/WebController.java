package spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring-kafka")
public class WebController {

    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping("/producer")
    public String producer(@RequestParam("message") String message, @RequestParam(value = "count", defaultValue = "1") int count) {
        kafkaSender.send(message, count);
        return String.format("Message [%s] sucessfully sent to kafka.", message);
    }
}
