package ru.skypro.diplomawork.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.diplomawork.service.ImageService;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping(path = "/image")
public class ImageController {

    private  final ImageService imageService;

    @GetMapping(value = "{id}", produces = {MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getAdsImage(@PathVariable Long id) {
        return ResponseEntity.ok(imageService.getAdsImage(id));
    }
}
