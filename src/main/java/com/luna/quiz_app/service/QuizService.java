package com.luna.quiz_app.service;

import com.luna.quiz_app.dao.QuestionDao;
import com.luna.quiz_app.dao.QuizDao;
import com.luna.quiz_app.model.Question;
import com.luna.quiz_app.model.Quiz;
import java.util.Collections;
import java.util.List;
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
}
