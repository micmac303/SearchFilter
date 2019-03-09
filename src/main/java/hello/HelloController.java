package hello;

import com.google.api.services.youtube.model.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import timeless.solutions.repository.ChannelRepository;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private QuickStart quickStart;

    @Autowired
    private ChannelRepository channelRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/search")
    public List<SearchResult> search(@RequestParam(value="query") String query) {

        return quickStart.search(query);
    }

    @RequestMapping("hide")
    public String hide(@RequestParam(value = "channelId") String channelId) {

        //add channelId to hidden list
        channelRepository.save(new Channel(channelId));
        return "hidden";
    }

}
