package cc.kamma.websocket.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.util.concurrent.CountDownLatch;

@Service
public class GdaxWebsocketClient implements ApplicationRunner {
    @Autowired
    private GdaxWebsocketHandler gdaxWebsocketHandler;
    private CountDownLatch latch;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true) {
            this.latch = new CountDownLatch(1);
            StandardWebSocketClient client = new StandardWebSocketClient();
            client.doHandshake(gdaxWebsocketHandler, "wss://ws-feed.gdax.com");
            latch.await();
        }
    }

    public void closed() {
        latch.countDown();
    }
}
