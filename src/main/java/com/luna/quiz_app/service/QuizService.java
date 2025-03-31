package com.luna.quiz_app.service;

import com.luna.quiz_app.dao.QuestionDao;
import com.luna.quiz_app.dao.QuizDao;
import com.luna.quiz_app.model.Question;
import com.luna.quiz_app.model.QuestionWrapper;
import com.luna.quiz_app.model.Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title){;
        List<Question> questions = questionDao.findByCategory(category);
        if (questions.size() < numQ) {
            return new ResponseEntity<>("Not enough questions available in this category", HttpStatus.BAD_REQUEST);
        }

        Collections.shuffle(questions);
        List<Question> selectedQuestions = questions.subList(0, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(selectedQuestions);

        try{
            quizDao.save(quiz);
            return new ResponseEntity<>("Quiz created successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>("Failed to create quiz!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        
    }

    public ResponseEntity<String> deleteQuiz(int id) {
        if(quizDao.existsById(id)){
            try{
                quizDao.deleteById(id);
                return new ResponseEntity<>("Quiz " + id + " deleted successfully!", HttpStatus.OK);
            } catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>("Failed to delete quiz!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Quiz with ID " + id + " not found!", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Quiz> getQuizById(int id) {
        return quizDao.findById(id)
                .map(quiz -> new ResponseEntity<>(quiz, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<List<Quiz>> getAllQuiz() {
        try{
            return new ResponseEntity<>(quizDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);

        if(quiz.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<QuestionWrapper> questionsForUser = quiz.get().getQuestions().stream()
            .map(q -> new QuestionWrapper(
                    q.getId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4()
            ))
            .collect(Collectors.toCollection(ArrayList::new));

        Collections.shuffle(questionsForUser);
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }
}
