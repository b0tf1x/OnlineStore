package user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String phoneNumber;
    @NotNull
    @NotBlank
    private String first_name;
    @NotNull
    @NotBlank
    private String second_name;
    private LocalDateTime dateOfBirth;
}
