package com.example.demo.controller.http;

import com.example.demo.data.LinkObject;
import com.example.demo.service.LinkService;
import com.example.demo.util.WatermelonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api")
public class HttpController {

    @Autowired
    private LinkService linkService;

    /**
     * 长网址转换为短网址.
     */
    @RequestMapping(value = "convert", method = RequestMethod.POST)
    public String convertShortLink(@RequestParam String longLink, @RequestParam String key) {
        if (longLink == null || longLink.isEmpty()) return null;
        if (longLink.startsWith("https://") || longLink.startsWith("http://")) {
            String[] shortUrls = WatermelonUtils.ShortText(longLink, key);
            for (String url : shortUrls) {
                LinkObject oldObject = linkService.findByLinkObjectKeyword(url);
                if (oldObject == null) {
                    LinkObject linkObject = new LinkObject();
                    linkObject.setLongLink(longLink);
                    linkObject.setKeyword(url);
                    linkObject.setCount(0);
                    linkService.save(linkObject);
                    return url;
                }
            }
            return null;
        } else {
            return "转换的长网址有误！";
        }
    }

    /**短网址访问跳转.*/
    @RequestMapping("/jump/{url}")
    @ResponseBody
    public void shortJump(@PathVariable("url") String url, HttpServletResponse resp) throws IOException {
        LinkObject linkData = linkService.findByLinkObjectKeyword(url);
        linkData.setCount(linkData.getCount() + 1);
        String longLink = linkService.save(linkData).getLongLink();
        resp.sendRedirect(longLink);
    }

    @RequestMapping("/index")
    public String index() {
        return "hello world";
    }




}
