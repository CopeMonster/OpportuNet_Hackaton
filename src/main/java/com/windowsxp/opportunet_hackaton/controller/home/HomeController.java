package com.windowsxp.opportunet_hackaton.controller.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.windowsxp.opportunet_hackaton.config.React;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final React react;

    @RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String mainPage(Model model) throws IOException, FileNotFoundException, ScriptException {

        String renderedHTML = react.renderEntryPoint();

        model.addAttribute("content", renderedHTML);

        return "index";
    }
}
