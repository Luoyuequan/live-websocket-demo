package cn.luoyuequan.websocketdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p></p>
 *
 * @author luoyuequan
 * @date 2020/03/30
 * @time 13:12
 */
@Controller
@RequestMapping
public class VideoController {
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/camera")
    public ModelAndView camera() {
        return new ModelAndView("camera");
    }
}
