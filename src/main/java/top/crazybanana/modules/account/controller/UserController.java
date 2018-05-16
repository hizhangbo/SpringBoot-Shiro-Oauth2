package top.crazybanana.modules.account.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.crazybanana.domain.common.R;
import top.crazybanana.domain.modules.account.User;
import top.crazybanana.modules.account.service.UserService;
import top.crazybanana.modules.account.service.impl.UserServiceImpl;
import top.crazybanana.modules.base.controller.BaseController;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public R list(){
        List<User> users = userService.getAll();
        return R.ok(users);
    }

    @RequestMapping("/upload")
    public R upload(@RequestBody MultipartFile file) throws IOException {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss"));
        // 用uuid作为文件名，防止生成的临时文件重复
        final File excelFile = File.createTempFile(date, prefix);
        // MultipartFile to File
        file.transferTo(excelFile);

        byte[] data = file.getBytes();
        OutputStream outputStream = new FileOutputStream(excelFile);
        outputStream.write(data);
        outputStream.close();

        return R.ok();
    }


    @RequestMapping("/addAll")
    public R addAll(@RequestBody List<User> users){


        return R.ok();
    }
}
