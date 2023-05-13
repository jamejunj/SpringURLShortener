package com.sjassist.redirect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjassist.redirect.repositories.URLRepository;
import com.sjassist.redirect.model.URL;

import java.util.List;

@Service
public class URLService {
    private final URLRepository urlRepository;

    @Autowired
    public URLService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public List<URL> getAllURLs(){
        return urlRepository.findAll();
    }

    public URL getURLById(Long id){
        return urlRepository.findById(id).orElse(null);
    }

    public URL addURL(URL url){
        return urlRepository.save(url);
    }

    public void deleteURL(Long id){
        urlRepository.deleteById(id);
    }

    public URL updateURL(Long id, URL url){
        URL existingURL = urlRepository.findById(id).orElse(null);
        existingURL.setUrl(url.getUrl());
        existingURL.setTitle(url.getTitle());
        existingURL.setDescription(url.getDescription());
        existingURL.setShortString(url.getShortString());
        return urlRepository.save(existingURL);
    }
}