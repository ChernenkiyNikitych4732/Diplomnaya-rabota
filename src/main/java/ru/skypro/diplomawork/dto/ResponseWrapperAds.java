package ru.skypro.diplomawork.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseWrapperAds {
    private int count;
    private List<AdsDto> results;
}
