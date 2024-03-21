package ru.skypro.diplomawork.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.diplomawork.entity.Ads;


public interface ImageService {
    byte[] updateAdsImage(long id, MultipartFile file);

    byte[] getAdsImage(Long id);
}
