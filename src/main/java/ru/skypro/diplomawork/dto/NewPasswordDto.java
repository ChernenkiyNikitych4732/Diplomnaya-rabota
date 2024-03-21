package ru.skypro.diplomawork.dto;

import lombok.Data;

@Data
public class NewPasswordDto {

    private String currentPassword;
    private String newPassword;

}
