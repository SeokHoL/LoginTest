package kr.ac.kopo.logintest.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sample/")
public class SampleController {

    @GetMapping("/all") //메서드 이름을 기본 뷰 이름으로 간주하여 자동으로 템플릿 파일을 찾습니다
    public void exAll(){
        log.info("★ exAll() 메소드 호출됨");

    }

    @GetMapping("/member")
    public void exMember(){
        log.info("★★ exMember() 메소드 호출됨");
    }

    @GetMapping("/admin")
    public void exAdmin(){
        log.info("★★★ exAdmin() 메소드 호출됨");
    }
}
