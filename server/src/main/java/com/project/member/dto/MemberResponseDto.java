package com.project.member.dto;

import com.project.member.entity.Member;
import lombok.*;

/**
 * @author Jaeyoung Bang
 */
public class MemberResponseDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Post {
        private String name;
        private String email;
        private String nickname;

        public static MemberResponseDto.Post fromEntity(Member member) {
            return MemberResponseDto.Post.builder()
                    .name(member.getName())
                    .email(member.getEmail())
                    .nickname(member.getNickname())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Get {
        private Long id;
        private String name;

        public static MemberResponseDto.Get fromEntity(Member member) {
            return MemberResponseDto.Get.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .build();
        }
    }
}
