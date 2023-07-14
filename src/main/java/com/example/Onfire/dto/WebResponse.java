package com.example.Onfire.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Builder
@Data
public class WebResponse<T> {

    private T data;

    private String errors;

    private PagingResponse pagingResponse;
}
