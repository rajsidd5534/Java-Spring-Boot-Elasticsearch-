package com.undoInternship.UndoInternship.service;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.undoInternship.UndoInternship.document.CourseDocument;
import com.undoInternship.UndoInternship.dto.CourseSearchResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseSearchService {


    private final ElasticsearchClient client;

    public CourseSearchService(ElasticsearchClient client) {
        this.client = client;
    }

    public CourseSearchResponse searchCourses(String keyword, int page, int size) throws Exception {
        int from = page * size;

        SearchRequest request;

        if (keyword == null || keyword.trim().isEmpty()) {
            // 🔍 Match All if keyword not provided
            request = new SearchRequest.Builder()
                    .index("courses")
                    .from(from)
                    .size(size)
                    .query(q -> q.matchAll(m -> m))
                    .build();
        } else {
            // 🔍 Multi-match keyword search in title & description
            request = new SearchRequest.Builder()
                    .index("courses")
                    .from(from)
                    .size(size)
                    .query(q -> q.multiMatch(m -> m
                            .fields("title", "description")  // also consider "title.keyword" if needed
                            .query(keyword)))
                    .build();
        }

        SearchResponse<CourseDocument> response = client.search(request, CourseDocument.class);

        List<CourseDocument> courses = new ArrayList<>();
        response.hits().hits().forEach(hit -> courses.add(hit.source()));

        long total = response.hits().total() != null ? response.hits().total().value() : 0;

        return new CourseSearchResponse(total, courses);
    }
}