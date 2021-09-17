package com.example.inetofficewebsite.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.inetofficewebsite.pojo.Introduce;
import com.example.inetofficewebsite.result.Result;
import com.example.inetofficewebsite.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IntroduceController {
    @Autowired
    IntroduceService introduceService;

    @PutMapping("/addIntroduce")
    public Result addIntroduce(@RequestParam("introduce_text")String introduceText){
        return new Result().result200(introduceService.addIntroduceService(introduceText));
    }

    @GetMapping("/listIntroduces")
    public Result listIntroduces(){
        return new Result().result200(introduceService.listIntroduces(1,20));
    }

    @DeleteMapping("/deleteIntroduce")
    public Result deleteIntroduce(@RequestParam Integer id){
        return new Result().result200(introduceService.deleteIntroduce(id));
    }
}
