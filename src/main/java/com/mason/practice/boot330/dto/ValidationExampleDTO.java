
package com.mason.practice.boot330.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ValidationExampleDTO {

    @NotNull(message = "ID는 null일 수 없습니다.")
    @Min(value = 1, message = "ID는 1보다 커야 합니다.")
    private Long id;

    @NotBlank(message = "이름은 공백일 수 없습니다.")
    @Size(min = 2, max = 50, message = "이름은 2자 이상 50자 이하여야 합니다.")
    private String name;

    @Email(message = "유효한 이메일 주소여야 합니다.")
    @NotBlank(message = "이메일은 공백일 수 없습니다.")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "전화번호는 10자리 숫자여야 합니다.")
    private String phoneNumber;
}
