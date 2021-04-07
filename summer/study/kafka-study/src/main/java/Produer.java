import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author dsx
 */
public class Produer {
    public static void main(String[] args) {
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.175.130:9092");
        p.put(ProducerConfig.ACKS_CONFIG, "all");
        p.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        p.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        p.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        KafkaProducer<String, String> producer = new KafkaProducer<>(p);

        producer.send(new ProducerRecord<String, String>("quickstart-events","hello world"));

        producer.close();

    }
}
