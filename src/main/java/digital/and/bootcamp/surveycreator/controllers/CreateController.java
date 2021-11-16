package digital.and.bootcamp.surveycreator.controllers;

import digital.and.bootcamp.surveycreator.models.Survey;
import digital.and.bootcamp.surveycreator.service.SurveyPersistenceSurvey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/survey")
public class CreateController {
    @Autowired
    SurveyPersistenceSurvey surveyPersistenceSurvey;

    @GetMapping("/{id}")
    public Survey getSurveyById(@PathVariable String id) {
        return Survey.builder()
                .name("My Survey")
                .questions(Collections.singletonList("How are you?"))
                .build();
    }

    @GetMapping("/all")
    public List<Survey> getAllSurveys(){
        return Collections.emptyList();
    }

    @PostMapping(path = "/create", consumes = "application/json")
    public String createSurvey(@RequestBody Survey survey) {
        return UUID.randomUUID().toString();
    }
}
