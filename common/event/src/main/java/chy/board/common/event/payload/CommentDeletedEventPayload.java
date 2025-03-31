package chy.board.common.event.payload;

import java.time.LocalDateTime;

import chy.board.common.event.EventPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDeletedEventPayload implements EventPayload {
	private Long commentId;
	private String content;
	private Long parentCommentId;
	private Long articleId;
	private Long writerId;
	private Boolean deleted;
	private LocalDateTime createdAt;
	private Long articleCommentCount;
}
