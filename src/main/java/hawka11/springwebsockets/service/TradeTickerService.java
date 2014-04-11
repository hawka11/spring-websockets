package hawka11.springwebsockets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.AbstractSubscribableChannel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TradeTickerService {

    @Autowired
    @Qualifier("brokerMessagingTemplate")
    private SimpMessagingTemplate brokerMessagingTemplate;

    private AtomicInteger aInt = new AtomicInteger(1);

    @Scheduled(fixedDelay = 2000)
    public void sendUpdate() {
        brokerMessagingTemplate.convertAndSend("/topic/greeting", "heres an update: " + aInt.getAndIncrement());
    }
}



