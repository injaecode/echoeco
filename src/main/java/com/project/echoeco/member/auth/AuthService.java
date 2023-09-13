package com.project.echoeco.member.auth;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.echoeco.common.constant.Role;
import com.project.echoeco.common.exception.AppException;
import com.project.echoeco.common.exception.ErrorCode;
import com.project.echoeco.config.Token.TokenCreation;
import com.project.echoeco.config.Token.TokenProvider;
import com.project.echoeco.member.Member;
import com.project.echoeco.member.MemberInfoResponse;
import com.project.echoeco.member.MemberJoinRequest;
import com.project.echoeco.member.MemberLoginRequest;
import com.project.echoeco.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
  private final AuthenticationManagerBuilder managerBuilder;
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;
  private final TokenProvider tokenProvider;

  public MemberInfoResponse signup(MemberJoinRequest dto) {
    if (memberRepository.existsByEmail(dto.getEmail())) {
      throw new AppException(ErrorCode.MEMBER_DUPLICATED, "이미 등록된 회원입니다");
    }

    Member member = Member.builder()
        .email(dto.getEmail())
        .nickname(dto.getName())
        .password(passwordEncoder.encode(dto.getPassword()))
        .tel(dto.getTel())
        .role(Role.MEMBER)
        .createdAt(LocalDateTime.now())
        .build();

    return MemberInfoResponse.fromMember(memberRepository.save(member));
  }

  public TokenCreation login(MemberLoginRequest dto) {
    UsernamePasswordAuthenticationToken authenticationToken = dto.toAuthentication();
    Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
    return tokenProvider.generateToken(authentication);
  }

}