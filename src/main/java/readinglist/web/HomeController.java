package readinglist.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import readinglist.security.Reader;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(@AuthenticationPrincipal Reader reader) {
        if (reader == null) {
            return "redirect:/login";
        } else {
            return "redirect:/readingList/" + reader.getUsername();
        }
    }

}
