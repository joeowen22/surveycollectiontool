package digital.and.bootcamp.surveycreator;

import digital.and.bootcamp.surveycreator.models.Survey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SurveyCreatorApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetSurveyByIdReturns() {
		Survey survey = restTemplate.getForObject("http://localhost:" + port + "/survey/1", Survey.class);
		assertEquals("My Survey", survey.getName());
		assertFalse(survey.getQuestions().isEmpty());
		assertEquals("How are you?", survey.getQuestions().get(0));
		assertNotNull(survey.getId());
	}

	@Test
	void getAllSurveys() {
		Survey[] survey = restTemplate.getForObject("http://localhost:" + port + "/survey/all", Survey[].class);
		assertEquals(0, survey.length);
	}

	@Test
	void createSurvey() {
		Survey test = Survey.builder()
				.name("Test")
				.questions(Collections.emptyList())
				.build();
		String response = restTemplate.postForObject("http://localhost:" + port + "/survey/create", test, String.class);
		assertNotNull(response);
	}

}
