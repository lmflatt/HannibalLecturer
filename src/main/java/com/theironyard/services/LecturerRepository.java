package com.theironyard.services;

import com.theironyard.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lee on 10/14/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
}
