package spring.kafka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring-kafka")
public class WebController {

    private final KafkaSender kafkaSender;

    public WebController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @GetMapping("/producer")
    public String producer(@RequestParam("message") String message, @RequestParam(value = "count", defaultValue = "1") int count) {
        kafkaSender.send(message, count);
        return String.format("Message [%s] sucessfully sent to kafka.", message);
    }
}
