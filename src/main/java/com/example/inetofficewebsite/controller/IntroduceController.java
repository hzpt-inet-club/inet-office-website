package com.example.inetofficewebsite.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.inetofficewebsite.pojo.Introduce;
import com.example.inetofficewebsite.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IntroduceController {
    @Autowired
    IntroduceService introduceService;

    @PutMapping("/addIntroduce")
    public Integer addIntroduce(@RequestParam("introduce_text")String introduceText){
        return introduceService.addIntroduceService(introduceText);
    }

    @GetMapping("/listIntroduces")
    public IPage<Introduce> listIntroduces(){
        return introduceService.listIntroduces(1,20);
    }

    @DeleteMapping("/deleteIntroduce")
    public Integer deleteIntroduce(@RequestParam Integer id){
        return introduceService.deleteIntroduce(id);
    }
}
