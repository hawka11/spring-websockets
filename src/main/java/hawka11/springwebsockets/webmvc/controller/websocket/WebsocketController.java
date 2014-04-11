package hawka11.springwebsockets.webmvc.controller.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

    private SimpMessagingTemplate template;

    @Autowired
    public WebsocketController(SimpMessagingTemplate template) {
        this.template = template;
        this.template.setSendTimeout(5);
    }

    @MessageMapping("/greeting")
    public String handle(Message<byte[]> msg) {
        this.template.convertAndSendToUser("mekeith", "/userspecificqueue", "rate 1.23");

        return "||Keith: " + new String(msg.getPayload());
    }
}