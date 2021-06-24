package streams;

import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;


public class SimpleStreamsExercisesb {
  
  public static void main(String[] args) throws InterruptedException, IOException {
    if (args.length != 2) {
      System.err.println("Wrong arguments. Please run the class as follows:");
      System.err.println(SimpleStreamsExercisesb.class.getName() + " input-topic output-topic");
      System.exit(1);
    }
    String topicName = args[0].toString();
    String outtopicname = args[1].toString();
    
    java.util.Properties props = new Properties();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "exercises-application-b");
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
    props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.Long().getClass());
    
    StreamsBuilder builder = new StreamsBuilder();
    KStream<String, Long> lines = builder.stream(topicName);
    
    KTable<String, Long> outlines = lines.groupByKey().count();
    
    outlines.mapValues(v -> "" + v).toStream().to(outtopicname, Produced.with(Serdes.String(), Serdes.String()));
    
    KafkaStreams streams = new KafkaStreams(builder.build(), props);
    streams.start();
    
  }
}