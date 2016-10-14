package com.theironyard.services;

import com.theironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by lee on 10/14/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findByLecturerId(int lecturerId);
}
