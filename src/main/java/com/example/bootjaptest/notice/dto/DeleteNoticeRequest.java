package com.example.bootjaptest.notice.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DeleteNoticeRequest {

    private List<Long> idList;

}
