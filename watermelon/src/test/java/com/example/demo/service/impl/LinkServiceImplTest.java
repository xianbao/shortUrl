package com.example.demo.service.impl;

import com.example.demo.data.LinkObject;
import com.example.demo.service.LinkService;
import com.example.demo.util.WatermelonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.awt.image.ImageWatched;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkServiceImplTest {

    @Autowired
    private LinkService linkService;

    @Test
    public void save() {
        LinkObject object = new LinkObject();
        String longLink = "http://www.baidu.com.cn";
        String shortUrl = WatermelonUtils.ShortText(longLink, "test")[0];
        object.setLongLink(longLink);
        object.setKeyword(shortUrl);
        object.setCount(0);
        LinkObject newObject = linkService.save(object);
    }

    @Test
    public void findByLinkObjectKeyword() {
        String keyword = "VzyYFf";
        LinkObject linkObject = linkService.findByLinkObjectKeyword(keyword);
    }
}