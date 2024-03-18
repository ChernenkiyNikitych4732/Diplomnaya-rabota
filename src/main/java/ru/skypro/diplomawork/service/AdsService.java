package ru.skypro.diplomawork.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.diplomawork.dto.AdsDto;
import ru.skypro.diplomawork.dto.CreateAdsDto;
import ru.skypro.diplomawork.dto.FullAdsDto;
import ru.skypro.diplomawork.dto.ResponseWrapperAds;
import ru.skypro.diplomawork.entity.Ads;

public interface AdsService {
    ResponseWrapperAds getAllAds();

    Ads getAdsById(long id);

    AdsDto createAds(CreateAdsDto createAdsDto, MultipartFile image, Authentication authentication);

    FullAdsDto getFullAdsById(long id);

    void removeAds(long id, Authentication authentication);

    AdsDto updateAdsById(long id, CreateAdsDto createAdsDto, Authentication authentication);

    ResponseWrapperAds getAllAdsForUser(String username);
}
