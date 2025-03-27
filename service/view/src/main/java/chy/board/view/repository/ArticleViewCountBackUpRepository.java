package chy.board.view.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import chy.board.view.entity.ArticleViewCount;

@Repository
public interface ArticleViewCountBackUpRepository extends JpaRepository<ArticleViewCount, Long> {
	@Query(
		value = "update article_view_count set view_count = :viewCount " +
				"where article_id = :articleId and view_count < :viewCount",
		nativeQuery = true
	)
	@Modifying
	int updateViewCount(
		@Param("articleId") Long articleId,
		@Param("viewCount") Long viewCount
	);
}
