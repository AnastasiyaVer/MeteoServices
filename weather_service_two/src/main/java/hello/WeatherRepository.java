package hello;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@EnableScheduling
@Component
public class WeatherRepository {

    @Autowired
    RabbitTemplate rabbitTemplate;

    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
    Map<String,String> actionmap = new HashMap<>();
    int pressure;
    int humidity;

    @Scheduled(cron = "0 0/30 * * * *")
    public void initData() {
        String localDateTime = LocalDateTime.now().format(FORMATTER);
        pressure = 665+(int)(Math.random()*(815-665+1));
        humidity = (int)(Math.random()*101);
        actionmap.put("sTwoPressure"+localDateTime, String.valueOf(pressure));
        actionmap.put("sTwoHumidity"+localDateTime,String.valueOf(humidity));
        this.rabbitTemplate.convertAndSend(WebServiceConfig.MESSAGE_QUEUE, actionmap);
        actionmap.clear();
    }
}
