package com.group6.swp391.controller;

import com.group6.swp391.model.Feedback;
import com.group6.swp391.request.FeedbackRequest;
import com.group6.swp391.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/swp391/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/all_feedbacks")
    public ResponseEntity<?> getAllFeedbacks() {
        List<Feedback> feedbacks;
        try {
            feedbacks = feedbackService.getAllFeedbacks();
            if (feedbacks.isEmpty()) {
                return ResponseEntity.badRequest().body("Feedback list is empty");
            } else {
                return ResponseEntity.ok(feedbacks);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Get all feedbacks failed");
        }
    }

    @GetMapping("/feedbacks_by_product/{id}")
    public ResponseEntity<?> getFeedbacksByProductID(@PathVariable String id) {
        List<Feedback> feedbacks;
        try {
            feedbacks = feedbackService.getFeedbacksByProductID(id);
            if (feedbacks.isEmpty()) {
                return ResponseEntity.badRequest().body("No feedback found for product ID: " + id);
            } else {
                return ResponseEntity.ok(feedbacks);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error retrieving feedback for product ID: " + id);
        }
    }

    @PostMapping("/submit_feedback")
    public ResponseEntity<?> submitFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        try {
            Feedback feedback = feedbackService.saveFeedback(feedbackRequest);
            if (feedback != null) {
                return ResponseEntity.ok(feedback);
            } else {
                return ResponseEntity.badRequest().body("Error saving feedback: Invalid product, diamond, or user ID");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error saving feedback: " + e.getMessage());
        }
    }
}
