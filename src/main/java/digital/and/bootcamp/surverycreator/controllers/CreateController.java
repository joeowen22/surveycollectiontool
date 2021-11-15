package digital.and.bootcamp.surverycreator.controllers;

import digital.and.bootcamp.surverycreator.service.SurveyPersistenceSurvey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateController {
    @Autowired
    SurveyPersistenceSurvey surveyPersistenceSurvey;

    @GetMapping("/survey/{id}")
    public String getSurveyById(@PathVariable String id) {
        return "Hello";
    }
}
