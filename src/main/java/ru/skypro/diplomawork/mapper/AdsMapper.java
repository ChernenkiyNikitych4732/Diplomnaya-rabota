package ru.skypro.diplomawork.mapper;

import org.mapstruct.*;
import ru.skypro.diplomawork.dto.AdsDto;
import ru.skypro.diplomawork.dto.CreateAdsDto;
import ru.skypro.diplomawork.dto.FullAdsDto;
import ru.skypro.diplomawork.dto.ResponseWrapperAds;
import ru.skypro.diplomawork.entity.Ads;
import ru.skypro.diplomawork.entity.Image;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AdsMapper {
    @Mapping(source = "author.id", target = "author")
    @Mapping(source = "id", target = "pk")
    @Mapping(source = "images", target = "image", qualifiedByName = "getListOfImageLinks")
    AdsDto adsToAdsDto(Ads ads);

    @Mapping(source = "author", target = "author.id")
    @Mapping(source = "pk", target = "id")
    Ads adsDtoToAds(AdsDto adsDto);

    @Mapping(source = "size", target = "count")
    @Mapping(source = "adsList", target = "results")
    ResponseWrapperAds adsListToResponseWrapperAds(Integer size, List<Ads> adsList);

    Ads createAdsDtoToAds(CreateAdsDto createAdsDto);

    @Mapping(source = "author.firstName", target = "authorFirstName")
    @Mapping(source = "author.lastName", target = "authorLastName")
    @Mapping(source = "author.username", target = "email")
    @Mapping(source = "author.phone", target = "phone")
    @Mapping(source = "id", target = "pk")
    @Mapping(source = "images", target = "image", qualifiedByName = "getListOfImageLinks")
    FullAdsDto adsToFullAdsDto(Ads ads);

    @Named("getListOfImageLinks")
    default List<String> getListOfImageLinks(List<Image> images) {
        return (images == null || images.isEmpty()) ? null :
                images.stream().map(i -> "/image/" + i.getId()).collect(Collectors.toList());
    }
}
