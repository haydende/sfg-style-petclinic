package haydende.sfgstylepetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // If there are any requests for /, "" index or index.html, they will be
    // matched with this mapping
    @RequestMapping({"/", "", "index", "index.html"})
    public String index() {
        return "index";
    }


}
