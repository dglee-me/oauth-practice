package kr.co.dglee.board.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/posts")
@RestController
public class PostsPageController {

    @GetMapping
    public String posts(@AuthenticationPrincipal OidcUser user) {
        return "%s님의 게시판입니다."
                .formatted(user.getName());
    }
}
