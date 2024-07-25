package com.example.wms.UserController;

import com.example.wms.poji.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController

public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username,Integer age,MultipartFile image)throws IOException {

        String s =  image.getOriginalFilename();


        String newf = UUID.randomUUID().toString() + s.substring(s.lastIndexOf("."));

        image.transferTo(new File("E:\\images\\"+newf));

        return Result.success();

    }

}
