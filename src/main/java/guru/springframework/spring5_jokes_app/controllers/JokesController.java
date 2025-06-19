package guru.springframework.spring5_jokes_app.controllers;

import guru.springframework.spring5_jokes_app.services.JokesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JokesController {

    private final JokesService jokesService;

    public JokesController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping({"/", ""})
    public String showJokes(Model model) {
        model.addAttribute("jokes", jokesService.getJokes());
        return "index";
    }

    @GetMapping("/fun")
    public @ResponseBody String showFun() {
        return jokesService.getFun();
    }
}
