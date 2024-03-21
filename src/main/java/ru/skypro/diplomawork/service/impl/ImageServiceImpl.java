package ru.skypro.diplomawork.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.diplomawork.entity.Ads;
import ru.skypro.diplomawork.exceptions.EmptyFileException;
import ru.skypro.diplomawork.exceptions.ImageCanNotBeReadException;
import ru.skypro.diplomawork.exceptions.ImageNotFoundException;
import ru.skypro.diplomawork.service.ImageService;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public byte[] updateAdsImage(long id, MultipartFile file) {
        return new byte[0];
    }

    @Override
    public byte[] getAdsImage(Long id) {
        return new byte[0];
    }

    /**
     * Receive old image by id, update and save.
     *
     * @param id identification number of an image
     * @param file {@link MultipartFile} with an image
     * @return byte array
     * @throws ImageNotFoundException if no image was found
     */


    /**
     * Create new image for ads.
     *
     * @param file {@link MultipartFile} with an image
     * @param ads {@link Ads} instance
     * @return image created
     */


    /**
     * Get image for ads by image id.
     *
     * @param id identification number of an image
     * @return byte array
     */
}