package io.ggammu.springcloudstreamrabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JobRequestProducerTest {

    @Autowired
    private JobRequestProducer producer;

    @Test
    void sendMessage() throws JsonProcessingException {
        // given
        producer.send("test");
        producer.send("error");
    }


}