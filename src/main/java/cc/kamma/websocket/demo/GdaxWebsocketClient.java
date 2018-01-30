package cc.kamma.websocket.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Service
public class GdaxWebsocketClient implements ApplicationRunner {
    @Autowired
    private GdaxWebsocketHandler gdaxWebsocketHandler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        StandardWebSocketClient client = new StandardWebSocketClient();
        client.doHandshake(gdaxWebsocketHandler, "wss://ws-feed.gdax.com");
    }
}
