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
    int temperature;
    int windSpeed;

    @Scheduled(cron = "0 0/15 * * * *")
    public void initData() {
        String localDateTime = LocalDateTime.now().format(FORMATTER);
        temperature = -50+(int)(Math.random()*101);
        windSpeed = (int)(Math.random()*31);
            actionmap.put("sOneTemperature"+localDateTime, String.valueOf(temperature));
            actionmap.put("sOneWindSpeed"+localDateTime,String.valueOf(windSpeed));
        this.rabbitTemplate.convertAndSend(WebServiceConfig.MESSAGE_QUEUE, actionmap);
        actionmap.clear();
    }
}
