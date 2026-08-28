package kr.co.dglee.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/posts")
@RestController
public class PostsController {

    @GetMapping
    public String getPosts() {
        return "게시글1";
    }
}
