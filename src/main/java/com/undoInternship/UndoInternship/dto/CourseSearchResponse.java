package com.undoInternship.UndoInternship.dto;

import com.undoInternship.UndoInternship.document.CourseDocument;

import java.util.List;

public class CourseSearchResponse {

    private long total;
    private List<CourseDocument> courses;

    // ✅ No-arg constructor (needed for deserialization)
    public CourseSearchResponse() {
    }

    // ✅ All-args constructor
    public CourseSearchResponse(long total, List<CourseDocument> courses) {
        this.total = total;
        this.courses = courses;
    }

    // ✅ Getters and Setters
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<CourseDocument> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDocument> courses) {
        this.courses = courses;
    }

    // ✅ Optional: toString() for easy debugging/logging
    @Override
    public String toString() {
        return "CourseSearchResponse{" +
                "total=" + total +
                ", courses=" + courses +
                '}';
    }
}
