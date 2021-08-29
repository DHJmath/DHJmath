package com.math.DHJmath.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    @Id
    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private int boardLevel;
    private int boardHit;
    private Date boardDate;
    private int memberNo;
    private int cateNo;



}
