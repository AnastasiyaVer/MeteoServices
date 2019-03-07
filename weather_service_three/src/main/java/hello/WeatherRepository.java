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
    int humidity;

    @Scheduled(cron = "0 0/45 * * * *")
    public void initData() {
        String localDateTime = LocalDateTime.now().format(FORMATTER);
        temperature = -50+(int)(Math.random()*101);
        humidity = (int)(Math.random()*101);
        actionmap.put("sThreeTemperature"+localDateTime, String.valueOf(temperature));
        actionmap.put("sThreeHumidity"+localDateTime,String.valueOf(humidity));
        this.rabbitTemplate.convertAndSend(WebServiceConfig.MESSAGE_QUEUE, actionmap);
        actionmap.clear();
    }
}
