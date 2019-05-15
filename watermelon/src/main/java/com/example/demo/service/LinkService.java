package com.example.demo.service;

import com.example.demo.data.LinkObject;

public interface LinkService {
    LinkObject save(LinkObject object);
    LinkObject findByLinkObjectKeyword(String keyword);

}
