package hello;

import com.google.api.services.youtube.model.SearchResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/search")
    public List<SearchResult> search() {

        QuickStart quickStart = new QuickStart();
        return quickStart.search("news");
    }

}
