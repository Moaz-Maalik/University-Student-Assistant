package com.example.ussa.Controller;

import com.example.ussa.repository.SwapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/Swapper")
public class SwapperController {
    @Autowired
    SwapperRepository swapperRepository;



}
