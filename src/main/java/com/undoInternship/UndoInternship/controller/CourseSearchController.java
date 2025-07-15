package com.undoInternship.UndoInternship.controller;

import com.undoInternship.UndoInternship.dto.CourseSearchResponse;
import com.undoInternship.UndoInternship.service.CourseSearchService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
@CrossOrigin(origins = "*") // ✅ Allow CORS for testing in browser (optional for security)
public class CourseSearchController {

    private final CourseSearchService courseSearchService;

    // ✅ Manual constructor
    public CourseSearchController(CourseSearchService courseSearchService) {
        this.courseSearchService = courseSearchService;
    }

    // ✅ GET /api/search?keyword=abc&page=0&size=10
    @GetMapping
    public CourseSearchResponse search(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) throws Exception {
        return courseSearchService.searchCourses(keyword, page, size);
    }
}
