
package com.mason.practice.boot330.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DatetimeExampleDTO {
    @NotNull(message = "datetime은 null일 수 없습니다.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") //Default format is yyyy-MM-dd'T'HH:mm:ss
    private LocalDateTime datetime;
}
