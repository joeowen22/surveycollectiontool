package digital.and.bootcamp.surveycreator.service;

import digital.and.bootcamp.surveycreator.models.Survey;
import org.springframework.stereotype.Service;

import java.util.*;

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
        return new ArrayList<>(surveys.values());
    }
}
