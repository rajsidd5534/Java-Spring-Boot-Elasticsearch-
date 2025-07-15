Course Search API – Spring Boot + Elasticsearch

A simple and efficient Course Search API built with **Spring Boot 3.5.3**, **Java 21**, and **Elasticsearch 8.18.1**. It supports full-text search, pagination, and filtering by session date.

---

##  Features

- Full-text course search (title, description, provider)
- Filter by `nextSessionDate`
- Pagination support
- Fast response with Elasticsearch relevance ranking
- Jackson `Instant` support via JSR310 module

---

##  Tech Stack

- Java 21
- Spring Boot 3.5.3
- Spring Data Elasticsearch 5.5.1
- Elasticsearch Java Client 8.18.1
- Jackson (JSR310 for Instant)

---

##  Project Structure

com.undoInternship
├── document/CourseDocument.java
├── repository/CourseRepository.java
├── service/CourseSearchService.java
├── controller/CourseSearchController.java
├── service/DataLoaderService.java
└── UndoInternshipApplication.java

yaml
Copy
Edit

---

##  Run Locally

### Prerequisites:
- Java 21
- Elasticsearch running on `localhost:9200`
- Maven

### Steps:
```bash
git clone https://github.com/your-username/course-search-api.git
cd course-search-api
mvn spring-boot:run
Optional: Start Elasticsearch via Docker
bash
Copy
Edit
docker run -d -p 9200:9200 \
  -e "discovery.type=single-node" \
  -e "xpack.security.enabled=false" \
  elasticsearch:8.18.1
 Example API Call
http
Copy
Edit
GET /search?query=spring&page=0&size=5
json
Copy
Edit
[
  {
    "title": "Spring Boot Basics",
    "provider": "Coursera",
    "description": "Learn Spring Boot",
    "nextSessionDate": "2025-08-01T00:00:00Z"
  }
]
 Common Fix
If you use Instant, make sure to register the JSR310 module:

java
Copy
Edit
mapper.registerModule(new JavaTimeModule());
 Author
Raj Siddiqui
📧 your-email@example.com
🔗 LinkedIn

yaml
Copy
Edit

---

Let me know if you want to:
- Add a Dockerfile
- Generate sample data
- Add Swagger docs
- Include a frontend (React) guide

I can update it further based on your goals.
