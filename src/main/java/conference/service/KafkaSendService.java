package conference.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.logging.Logger;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/25 9:46
 *
 * @version 1.0
 */
@Service
public class KafkaSendService {

    protected static final Log logger = LogFactory.getLog(KafkaSendService.class);
    @Autowired
    KafkaTemplate<String,String> stringKafkaTemplate;

    public int sendMessage(Object v) throws JsonProcessingException {

        String mess = new ObjectMapper().writeValueAsString(v);
        ListenableFuture<SendResult<String, String>> testTopic = stringKafkaTemplate.send("testTopic", "warning",mess);
        testTopic.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("=== Producing message failed");
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                logger.info("=== Producing message success");
            }
        });

        return 0;
    }
}
