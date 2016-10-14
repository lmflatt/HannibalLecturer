package com.theironyard.entities;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private int lecturerId;

    @Column(nullable = false)
    private boolean isGood = false;

    public Review() {
    }

    public Review(String author, String text, int lecturerId) {
        this.author = author;
        this.text = text;
        this.lecturerId = lecturerId;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public boolean isIsGood() {
        return isGood;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public void setIsGood(boolean good) {
        isGood = good;
    }
}
