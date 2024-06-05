package the.garis.bigf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import the.garis.bigf.service.TopicService;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    TopicService topicService;

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        String types = topicService.getTypes();

        model.put("types", types);

        return "index";
    }

    @PostMapping("/furtherInfo")
    public String furtherInfo() {
        return "furtherInfo";
    }
}
