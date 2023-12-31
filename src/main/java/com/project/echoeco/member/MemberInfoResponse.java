package com.project.echoeco.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberInfoResponse {
  private String email;
  private String nickname;

  public static MemberInfoResponse fromMember(Member member) {
    return MemberInfoResponse.builder()
        .email(member.getEmail())
        .nickname(member.getNickname())
        .build();
  }
}
