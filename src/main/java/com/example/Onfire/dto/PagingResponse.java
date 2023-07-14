package com.example.Onfire.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class PagingResponse {

    private Integer currentPage;

    private Integer totalPage;

    private Integer size;
}
