package chy.board.like.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "article_like_count")
@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleLikeCount {
	@Id
	private Long articleId;
	private Long likeCount;

	public static ArticleLikeCount init(Long articleId, Long likeCount) {
		ArticleLikeCount articleLikeCount = new ArticleLikeCount();
		articleLikeCount.articleId = articleId;
		articleLikeCount.likeCount = likeCount;
		return articleLikeCount;
	}
}
