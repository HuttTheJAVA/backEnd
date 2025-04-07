package chy.board.articleread.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chy.board.articleread.service.ArticleReadService;
import chy.board.articleread.service.response.ArticleReadPageResponse;
import chy.board.articleread.service.response.ArticleReadResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticleReadController {
	private final ArticleReadService articleReadService;

	@GetMapping("/v1/articles/{articleId}")
	public ArticleReadResponse read(@PathVariable Long articleId) {
		return articleReadService.read(articleId);
	}

	@GetMapping("/v1/articles")
	public ArticleReadPageResponse readAll(
		@RequestParam Long boardId,
		@RequestParam Long page,
		@RequestParam Long pageSize
	) {
		return articleReadService.readAll(boardId, page, pageSize);
	}

	@GetMapping("/v1/articles/infinite-scroll")
	public List<ArticleReadResponse> readAllInfiniteScroll(
		@RequestParam Long boardId,
		@RequestParam(required = false) Long lastArticleId,
		@RequestParam Long pageSize
	) {
		return articleReadService.readAllInfiniteScroll(boardId, lastArticleId, pageSize);
	}
}
