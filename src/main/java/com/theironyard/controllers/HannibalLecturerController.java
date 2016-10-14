package com.theironyard.controllers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class HannibalLecturerController {
    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void addReview(String author, String text, int lecturerId, boolean isGood, HttpServletResponse response) throws Exception {
        Review review = new Review(author, text, lecturerId);
        if (isGood) {
            review.setIsGood(true);
        }
        reviews.save(review);
        response.sendRedirect("/");
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public void addLecturer(String name, String topic, String image, HttpServletResponse response) throws Exception {
        lecturers.save(new Lecturer(name, topic, image));
        response.sendRedirect("/");
    }

    @RequestMapping(path = "/reviews/{lecturerId}", method = RequestMethod.GET)
    public List<Review> getReviews(@PathVariable("lecturerId") int lecturerId) {
        return reviews.findByLecturerId(lecturerId);
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public List<Review> getReviews() {
        return (List<Review>) reviews.findAll();
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public List<Lecturer> getLecturers() {
        return (List<Lecturer>) lecturers.findAll();
    }
}
