package com.undoInternship.UndoInternship.service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.undoInternship.UndoInternship.document.CourseDocument;
import com.undoInternship.UndoInternship.repository.CourseRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class DataLoaderService {

    private static final Logger logger = LoggerFactory.getLogger(DataLoaderService.class);
    private final CourseRepository courseRepository;

    public DataLoaderService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @PostConstruct
    public void loadCourses() {
        try {
            if (courseRepository.count() > 0) {
                logger.info("✅ Courses already loaded. Skipping reload.");
                return;
            }

            InputStream inputStream = getClass().getResourceAsStream("/sample-courses.json");

            if (inputStream == null) {
                logger.error("❌ sample-courses.json file not found in resources folder.");
                return;
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            List<CourseDocument> courses = mapper.readValue(
                    inputStream, new TypeReference<List<CourseDocument>>() {}
            );

            courseRepository.saveAll(courses);
            logger.info("✅ Loaded and saved {} courses into Elasticsearch", courses.size());

        } catch (Exception e) {
            logger.error("❌ Failed to load courses into Elasticsearch", e);
        }
    }
}