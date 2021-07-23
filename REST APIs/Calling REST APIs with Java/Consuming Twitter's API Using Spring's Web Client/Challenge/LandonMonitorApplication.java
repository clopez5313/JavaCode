import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linkedin.api.azure.AzureSentimentService;
import com.linkedin.api.azure.SentimentAnalysis;
import com.linkedin.api.twitter.StreamResponse;
import com.linkedin.api.twitter.TwitterStreamingService;

@Profile("!test")
@SpringBootApplication
public class LandonMonitorApplication implements CommandLineRunner {

	@Autowired
	private TwitterStreamingService twitterStreamingService;

	@Autowired
	private AzureSentimentService azureSentimentService;

	@Bean
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(LandonMonitorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.twitterStreamingService.stream().subscribe(tweet -> {
			System.out.println("The tweet says: " + tweet);

			try {
				StreamResponse response = this.mapper().readValue(tweet, StreamResponse.class);
				SentimentAnalysis sentiment = azureSentimentService.requestSentimentAnalysis(response.getData().getText(), "en");

				if(sentiment.getSentiment().equalsIgnoreCase("positive")) {
					System.out.println("The hotel received positive feedback.");
				}

				else if(sentiment.getSentiment().equalsIgnoreCase("negative")) {
					System.out.println("The hotel received negative feedback.");
				}
			}

			catch(Exception e) {
				System.out.println("A problem occurred when sending the request.");
				e.printStackTrace();
			}
		});
	}
}
