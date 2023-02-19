package io.ggammu.springcloudstreamrabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JobRequestProducer {

    private final StreamBridge streamBridge;
    private final ObjectMapper objectMapper;

//    @Async
    public void send(String message) throws JsonProcessingException {
        Message test = new Message();
        test.setName(message);
        String msg = objectMapper.writeValueAsString(test);
        System.out.println(msg);
        streamBridge.send("stream-out-0", msg);
    }

    class Message {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
