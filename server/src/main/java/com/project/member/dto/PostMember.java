package com.project.member.dto;

import com.project.member.entity.Member;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Jaeyoung Bang
 */
public class PostMember {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotNull(message = "공백이 아니어야 합니다")
        @Length(min = 1, max = 6, message = "이름은 1~6자여야 합니다")
        private String name;

        @NotNull(message = "공백이 아니어야 합니다")
        @Email(message = "올바른 이메일 형식이어야 합니다")
        private String email;

        @NotNull(message = "공백이 아니어야 합니다")
        @Length(min = 1, max = 10, message = "닉네임은 1~10자여야 합니다")
        private String nickname;

        @NotNull(message = "공백이 아니어야 합니다")
        @Pattern(regexp = "^((?=.*\\d)(?=.*[a-zA-Z])(?=.*\\W).{" + 8 + "," + 20 + "})$"
                , message = "비밀번호는 영문/숫자/특수문자 혼용, 8~20자여야 합니다")
        private String password;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private String name;
        private String email;
        private String nickname;

        public static Response fromEntity(Member member) {
            return Response.builder()
                    .name(member.getName())
                    .email(member.getEmail())
                    .nickname(member.getNickname())
                    .build();
        }
    }
}
