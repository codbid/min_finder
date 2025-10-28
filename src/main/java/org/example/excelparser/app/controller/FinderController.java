package org.example.excelparser.app.controller;

import lombok.RequiredArgsConstructor;
import org.example.excelparser.app.service.FinderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/finder")
public class FinderController {
    private final FinderService service;

    @GetMapping("/min-nth")
    public int findNthMin(
            @RequestParam String path,
            @RequestParam Integer n
    ) {
        return service.findNthMin(path, n);
    }
}
