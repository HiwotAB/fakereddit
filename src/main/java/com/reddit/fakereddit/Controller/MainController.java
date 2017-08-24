package com.reddit.fakereddit.Controller;

import com.reddit.fakereddit.Model.Link;
import com.reddit.fakereddit.Repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {
    @Autowired
    LinkRepository linkRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/addLink", method = GET)
    public String addLink(Model model) {
        model.addAttribute("aLink", new Link());
        return "formLink";
    }

    @RequestMapping(value = "/addLink", method = POST)
    public String addLinkConfirm(@Valid @ModelAttribute("aLink") Link aLink, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formLink";
        }
        aLink.setTimestamp(aTimeStamp());
        linkRepository.save(aLink);
        return "formConfirm";
    }

    @RequestMapping("/showLinks")
    public String showLink(Model model) {
        Iterable<Link> allLinks = linkRepository.findAll();
        model.addAttribute("allLink", allLinks);
        return "showLinks";
    }


    //update link
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("aLink", linkRepository.findOne(id));
        return "formLink";
    }

    //delete link
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        linkRepository.delete(id);
        return "redirect:/showLinks";
    }

    //set timestamp
    public Date aTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        Timestamp currentTimestamp = new Timestamp(now.getTime());
        return currentTimestamp;
    }
    @RequestMapping(value="/enterSearch",method=GET)
    public String enterSearch(Model model) {
        model.addAttribute("searchUser",new Link());
        return "search";
    }

    @RequestMapping(value="/enterSearch",method=POST)
    public String searchResult(@RequestParam("searchName") String name, Model model){
        model.addAttribute("allLink",linkRepository.findByUserName(name));
        return "showLinks";
    }


}