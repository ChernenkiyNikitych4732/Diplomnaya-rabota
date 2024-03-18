package ru.skypro.diplomawork.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.diplomawork.entity.Ads;
import ru.skypro.diplomawork.entity.Image;

public interface ImageService {
    byte[] updateAdsImage(long id, MultipartFile file);

    Image createImage(MultipartFile image, Ads ads);

    byte[] getAdsImage(Long id);
}
