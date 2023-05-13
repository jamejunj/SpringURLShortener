package com.sjassist.redirect.controllers;

import com.sjassist.redirect.model.URL;
import com.sjassist.redirect.services.URLService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("api/v1/urls")
public class URLController {
    private final URLService urlService;

    @Autowired
    public URLController(URLService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public List<URL> getAllURLs(){
        return urlService.getAllURLs();
    }

    @GetMapping("/{id}")
    public RedirectView getURLById(@PathVariable Long id){
        URL redirect_url = urlService.getURLById(id);
        RedirectView redirectView = new RedirectView();
        if(redirect_url != null){
            redirectView.setUrl(redirect_url.getUrl());
        }
        else{
            redirectView.setUrl("/404");
        }
        return redirectView;
    }

    // @PostMapping("/")
    // public URL addURL(@RequestBody URL url){
    //     return urlService.addURL(url);
    // }
    record URLRequest(String url, String title, String description, String shortString){}

    @PostMapping("/")
    public URL addURL(@RequestBody URLRequest request){
        URL url = new URL(request.url(), request.title(), request.description(), request.shortString());
        return urlService.addURL(url);
    }

    @DeleteMapping("/{id}")
    public void deleteURL(@PathVariable Long id){
        urlService.deleteURL(id);
    }

    @PutMapping("/{id}")
    public URL updateURL(@PathVariable("id") Long requestId, @RequestBody URLRequest request){
        URL url = new URL(request.url(), request.title(), request.description(), request.shortString());
        return urlService.updateURL(requestId, url);
    }
}
