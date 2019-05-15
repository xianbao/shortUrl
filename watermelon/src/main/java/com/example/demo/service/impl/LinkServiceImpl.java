package com.example.demo.service.impl;

import com.example.demo.data.LinkObject;
import com.example.demo.repository.LinkRepository;
import com.example.demo.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public LinkObject save(LinkObject object) {
        return linkRepository.save(object);
    }

    @Override
    public LinkObject findByLinkObjectKeyword(String keyword) {
        return linkRepository.findByKeyword(keyword);
    }
}
