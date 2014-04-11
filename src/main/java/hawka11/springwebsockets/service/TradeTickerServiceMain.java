package hawka11.springwebsockets.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TradeTickerServiceMain {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TradeTickerConfig.class);
        context.start();

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}