package ua.curs.work.controllers.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.curs.work.entities.News;
import ua.curs.work.form.NewsForm;
import ua.curs.work.services.news.impls.NewsServiceImpl;

import java.util.Collections;
import java.util.List;


@Controller
public class NewsWebController {

    private final NewsServiceImpl service;

    public NewsWebController(NewsServiceImpl service) {
        this.service = service;
    }


    @RequestMapping("/news")
    String getNews(Model model){
        List<News> news = service.getAll();
        Collections.reverse(news);
        model.addAttribute("newses", news);
        return "news"; }

    @RequestMapping("/news/{id}")
    String getOneNews(Model model,
                      @PathVariable("id") String id){
        News news = service.get(id);
        NewsForm newsForm = new NewsForm();
        newsForm.setPhotoUrl(news.getPhotoUrl());
        newsForm.setName(news.getName());
        newsForm.setMinText(news.getMinText());
        newsForm.setAllText(news.getAllText());
        model.addAttribute("newsForm", newsForm);
        return "oneNews"; }

    @RequestMapping("/web/news/list")
    String getAll(Model model){
        model.addAttribute("newses", service.getAll());
        return "newsList"; }

    @RequestMapping("/web/news/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("newses", service.getAll());
        return "redirect:/web/news/list";
    }


    @RequestMapping(value = "/web/news/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        News news = service.get(id);
        NewsForm newsForm = new NewsForm();
        newsForm.setPhotoUrl(news.getPhotoUrl());
        newsForm.setName(news.getName());
        newsForm.setMinText(news.getMinText());
        newsForm.setAllText(news.getAllText());
        model.addAttribute("newsForm", newsForm);
        return "newsAdd";
    }


    @RequestMapping(value = "/web/news/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                              @ModelAttribute("newsForm") NewsForm newsForm,
                              @PathVariable("id") String id){

        News news = new News();
        news.setId(newsForm.getId());
        news.setPhotoUrl(newsForm.getPhotoUrl());
        news.setName(newsForm.getName());
        news.setMinText(newsForm.getMinText());
        news.setAllText(newsForm.getAllText());
        service.edit(news);
        return "redirect:/web/news/list";
    }


    @RequestMapping(value = "/web/news/create", method = RequestMethod.GET)
    String create(Model model){
        NewsForm newsForm = new NewsForm();
        model.addAttribute("newsForm", newsForm);
        return "newsAdd";
    }
    @RequestMapping(value = "/web/news/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("newsForm") NewsForm newsForm){
        News news = new News();
        news.setPhotoUrl(newsForm.getPhotoUrl());
        news.setName(newsForm.getName());
        news.setMinText(newsForm.getMinText());
        news.setAllText(newsForm.getAllText());
        service.save(news);
        model.addAttribute("newses", service.save(news));
        return "redirect:/web/news/list";
    }

}
