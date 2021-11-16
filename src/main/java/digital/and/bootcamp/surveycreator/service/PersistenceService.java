package digital.and.bootcamp.surveycreator.service;

import digital.and.bootcamp.surveycreator.models.Survey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersistenceService {
    private final Map<String, Survey> surveys = new HashMap<>();

    public String persistSurvey(Survey survey) {
        surveys.put(survey.getId(), survey);
        return survey.getId();
    }

    public Survey getSurveyById(String id) {
        return surveys.get(id);
    }

    public List<Survey> getAllSurveys() {
        return (List<Survey>) surveys.values();
    }
}
