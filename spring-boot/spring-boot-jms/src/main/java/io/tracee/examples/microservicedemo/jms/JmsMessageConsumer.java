package io.tracee.examples.microservicedemo.jms;

import io.tracee.Tracee;
import io.tracee.TraceeBackend;
import io.tracee.TraceeConstants;
import io.tracee.binding.jms.TraceeMessageListener;
import io.tracee.examples.microservicedemo.jms.config.JmsConfig;
import org.slf4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.Map;

import static io.tracee.configuration.TraceeFilterConfiguration.Channel.AsyncProcess;


@Component
public class JmsMessageConsumer {

    @JmsListener(destination = JmsConfig.QUEUE) // "queue://" +
    public void receiveOrder(String calculation, Message message) {
        Logger logger = org.slf4j.LoggerFactory.getLogger(JmsMessageProducerService.class);


        try {
            beforeProcessing(message);

            logger.info("Do asynchronous calculation of {} - {}", calculation, message.getJMSMessageID());



        } catch (JMSException e) {
            logger.error("JMS processing error", e);
        } finally {
            cleanUp();
        }
        //storeService.registerOrder(order);

    }

    @SuppressWarnings("unchecked")
    public void beforeProcessing(final Message message) throws JMSException {
        TraceeBackend backend = Tracee.getBackend();
        if (backend.getConfiguration().shouldProcessContext(AsyncProcess)) {
            final Object encodedTraceeContext = message.getObjectProperty(TraceeConstants.TPIC_HEADER);
            if (encodedTraceeContext != null) {
                final Map<String, String> contextFromMessage = (Map<String, String>) encodedTraceeContext;
                backend.putAll(backend.getConfiguration().filterDeniedParams(contextFromMessage, AsyncProcess));
            }
        }

    }

    void cleanUp() {
        TraceeBackend backend = Tracee.getBackend();

        if (backend.getConfiguration().shouldProcessContext(AsyncProcess)) {
            backend.clear();
        }
    }

}
