package com.project.echoeco.board;

import javax.validation.constraints.NotNull;

import com.project.echoeco.common.BaseMember;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class BoardDTO{
	
	@NotNull(message = "제목을 입력해주세요")
	private String title;
	
	@NotNull(message = "내용을 입력해주세요")
	private String content;
	
	private Integer views;
	
	private Integer memberId;
}