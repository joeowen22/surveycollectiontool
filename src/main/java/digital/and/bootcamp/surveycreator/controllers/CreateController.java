package digital.and.bootcamp.surveycreator.controllers;

import digital.and.bootcamp.surveycreator.models.Survey;
import digital.and.bootcamp.surveycreator.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/survey")
public class CreateController {
    @Autowired
    PersistenceService persistenceService;

    @GetMapping("/{id}")
    public Survey getSurveyById(@PathVariable String id) {
        return persistenceService.getSurveyById(id);
    }

    @GetMapping("/all")
    public List<Survey> getAllSurveys(){
        return persistenceService.getAllSurveys();
    }

    @PostMapping(path = "/create", consumes = "application/json")
    public String createSurvey(@RequestBody Survey survey) {
        String surveyId = persistenceService.persistSurvey(survey);
        persistenceService.sendToSlack(surveyId, survey.getQuestions());
        return surveyId;
    }
}
