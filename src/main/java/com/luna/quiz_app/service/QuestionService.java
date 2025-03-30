package com.luna.quiz_app.service;

import com.luna.quiz_app.dao.QuestionDao;
import com.luna.quiz_app.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionDao.findAll();
        if (questions.isEmpty()) {
            return new ResponseEntity<>(questions, HttpStatus.OK); 
        }
        return new ResponseEntity<>(questions, HttpStatus.OK); 
    }

    public ResponseEntity<Question> getQuestion(Integer id) {
        return questionDao.findById(id)
                .map(question -> new ResponseEntity<>(question, HttpStatus.OK)) 
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));   
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            List<Question> questions = questionDao.findByCategory(category);
            if (questions.isEmpty()) {
                return new ResponseEntity<>(questions, HttpStatus.OK); 
            }
            return new ResponseEntity<>(questions, HttpStatus.OK); 
        } catch (Exception e) {
            e.printStackTrace(); 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> addQuestion(Question question){
        try{
            questionDao.save(question);
            return new ResponseEntity<>("Question added successfully!", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to add question!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        if (questionDao.existsById(id)) {
            try {
                questionDao.deleteById(id);
                return new ResponseEntity<>("Question " + id + " deleted successfully", HttpStatus.OK); 
            } catch (Exception e) {
                e.printStackTrace(); 
                return new ResponseEntity<>("Failed to delete the question", HttpStatus.INTERNAL_SERVER_ERROR); 
            }
        } else {
            return new ResponseEntity<>("Question with ID " + id + " not found", HttpStatus.NOT_FOUND); 
        }
    }

    public ResponseEntity<String> updateQuestion(int id, Question updatedQuestion) {
        return questionDao.findById(id)
                .map(existingQuestion -> {
                    copyUpdatedFields(existingQuestion, updatedQuestion);
                    questionDao.save(existingQuestion); 
                    return new ResponseEntity<>("Question " + id + " updated successfully!", HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>("Question with ID " + id + " does not exist", HttpStatus.NOT_FOUND));
    }
    
    private void copyUpdatedFields(Question existingQuestion, Question updatedQuestion) {
        existingQuestion.setCategory(updatedQuestion.getCategory());
        existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
        existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
        existingQuestion.setOption1(updatedQuestion.getOption1());
        existingQuestion.setOption2(updatedQuestion.getOption2());
        existingQuestion.setOption3(updatedQuestion.getOption3());
        existingQuestion.setOption4(updatedQuestion.getOption4());
        existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
    }
}
