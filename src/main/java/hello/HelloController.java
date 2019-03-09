package hello;

import com.google.api.services.youtube.model.SearchResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<SearchResult> search(@RequestParam(value="query") String query) {

        QuickStart quickStart = new QuickStart();
        System.out.println(query);
        return quickStart.search(query);
    }

    @RequestMapping("hide")
    public String hide() {
        return "Not yet implemented";
    }

}
