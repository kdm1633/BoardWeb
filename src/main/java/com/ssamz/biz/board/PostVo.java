package com.ssamz.biz.board;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostVo {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int hit;
	
	private String searchType;
	private String searchKeyword;
}
