package com.luna.quiz_app.controller;

import com.luna.quiz_app.model.QuestionWrapper;
import com.luna.quiz_app.model.Quiz;
import com.luna.quiz_app.model.Response;
import com.luna.quiz_app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping({"/", "getAllQuiz"})
    public ResponseEntity<List<Quiz>> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @GetMapping("{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable int id){
        return quizService.getQuizById(id);
    }

    @GetMapping("/getQuestions/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable int id){
        return quizService.deleteQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
    
}
