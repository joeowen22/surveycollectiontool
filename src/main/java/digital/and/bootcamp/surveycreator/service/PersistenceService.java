package digital.and.bootcamp.surveycreator.service;

import digital.and.bootcamp.surveycreator.models.Survey;
import digital.and.bootcamp.surveycreator.models.SurveySendRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@Service
public class PersistenceService {
    private final Map<String, Survey> surveys = new HashMap<>();

    public String persistSurvey(Survey survey) {
        surveys.put(survey.getId(), survey);
        return survey.getId();
    }

    public void sendToSlack(String surveyId, List<String> questions){
        RestTemplate restTemplate = new RestTemplate();
        SurveySendRequest surveySendRequest = SurveySendRequest.builder()
                .surveyId(surveyId)
                .questions(questions)
                .build();
        ResponseEntity<Void> response = restTemplate.postForEntity(System.getenv("SLACK_INT_ENDPOINT"), surveySendRequest, Void.class);
        log.info("Response Status: {}", response.getStatusCodeValue());
    }

    public Survey getSurveyById(String id) {
        return surveys.get(id);
    }

    public List<Survey> getAllSurveys() {
        return new ArrayList<>(surveys.values());
    }
}
