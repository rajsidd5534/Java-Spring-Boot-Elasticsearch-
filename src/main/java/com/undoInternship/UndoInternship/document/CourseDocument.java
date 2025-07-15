package com.undoInternship.UndoInternship.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true) //
@Document(indexName = "courses")
public class CourseDocument {

    @Id
    private String id;

    private String title;
    private String description;
    private String category;
    private String type;
    private String gradeRange;

    private int minAge;
    private int maxAge;

    private double price;

    private Instant nextSessionDate;

    // ✅ No-arg constructor
    public CourseDocument() {
    }

    // ✅ All-args constructor
    public CourseDocument(String id, String title, String description, String category, String type,
                          String gradeRange, int minAge, int maxAge, double price, Instant nextSessionDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.type = type;
        this.gradeRange = gradeRange;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.price = price;
        this.nextSessionDate = nextSessionDate;
    }

    // ✅ Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGradeRange() {
        return gradeRange;
    }

    public void setGradeRange(String gradeRange) {
        this.gradeRange = gradeRange;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Instant getNextSessionDate() {
        return nextSessionDate;
    }

    public void setNextSessionDate(Instant nextSessionDate) {
        this.nextSessionDate = nextSessionDate;
    }
}
