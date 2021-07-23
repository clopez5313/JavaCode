import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AzureSentimentService {

	@Value("${AZURE_API_KEY}")
	private String azureApiKey;

	@Autowired
	private ObjectMapper mapper;

	private static final String AZURE_ENDPOINT = "https://landon-hotel-clopez.cognitiveservices.azure.com";

	private static final String AZURE_ENDPOINT_PATH = "/text/analytics/v3.0/sentiment";

	private static final String API_KEY_HEADER_NAME = "Ocp-Apim-Subscription-Key";

	private static final String CONTENT_TYPE = "Content-Type";

	private static final String APPLICATION_JSON = "application/json";

	public SentimentAnalysis requestSentimentAnalysis(String text, String language) throws IOException, InterruptedException {
		TextDocument document = new TextDocument("1", text, language);
		SentimentAnalysis sentimentResponse = new SentimentAnalysis(document);
		TextAnalyticsRequest requestBody = new TextAnalyticsRequest();
		requestBody.getDocuments().add(document);

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(AZURE_ENDPOINT + AZURE_ENDPOINT_PATH))
				.header(CONTENT_TYPE, APPLICATION_JSON)
				.header(API_KEY_HEADER_NAME, this.azureApiKey)
				.POST(BodyPublishers.ofString(mapper.writeValueAsString(requestBody)))
				.build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		JsonNode node = mapper.readValue(response.body(), JsonNode.class);
		String value = node.get("documents")
				.get(0)
				.get("sentiment")
				.asText();
		sentimentResponse.setSentiment(value);

		return sentimentResponse;
	}
}
