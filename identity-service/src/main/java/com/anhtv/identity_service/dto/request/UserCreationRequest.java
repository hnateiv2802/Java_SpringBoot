package com.anhtv.identity_service.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @NotNull
    @Size(min = 5, message = "USERNAME_INVALID")
    String username;

    @NotNull
    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;

    @Size(min = 1, message = "Please enter your first name.")
    String firstName;

    @Size(min = 1, message = "Please enter your last name.")
    String lastName;

    @Past(message = "Enter your birthday!")
    LocalDate birthDate;


}
