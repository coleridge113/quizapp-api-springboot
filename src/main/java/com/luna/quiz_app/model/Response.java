package com.luna.quiz_app.model;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    @Id
    private int id;
    private String answer;
}
