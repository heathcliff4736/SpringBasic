package com.ssg.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long postId;
    private String title;
    private String content;
    private String writer;
    private String passphrase;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String createdAtStr;
    private String updatedAtStr;

    // 포맷 메서드
    public void formatDates() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        if (createdAt != null) this.createdAtStr = createdAt.format(formatter);
        if (updatedAt != null) this.updatedAtStr = updatedAt.format(formatter);
    }
}
