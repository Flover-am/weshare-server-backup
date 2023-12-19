package com.web.springboot.controller;

import com.web.springboot.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


@RestController
@RequestMapping("/log")
public class LogController {
    String log_path = "/home/floveram/coding/2/A.java";

    @GetMapping("/getlog")
    public String getLog(HttpServletRequest request) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(log_path));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = in.readLine()) != null) {
            sb.append(str);
            sb.append("\n");
        }
        return sb.toString();
    }
}
