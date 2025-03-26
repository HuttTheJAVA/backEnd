package chy.board.article.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import chy.board.article.service.ArticleService;
import chy.board.article.service.request.ArticleCreateRequest;
import chy.board.article.service.request.ArticleUpdateRequest;
import chy.board.article.service.response.ArticlePageResponse;
import chy.board.article.service.response.ArticleResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticleController {
	private final ArticleService articleService;

	@GetMapping("/v1/articles/{articleId}")
	public ArticleResponse read(@PathVariable Long articleId) {
		return articleService.read(articleId);
	}

	@GetMapping("/v1/articles")
	public ArticlePageResponse readAll(
		@RequestParam Long boardId,
		@RequestParam Long page,
		@RequestParam Long pageSize
	) {
		return articleService.readAll(boardId, page, pageSize);
	}

	@GetMapping("/v1/article/infinite-scroll")
	public List<ArticleResponse> readAllInfiniteScroll(
		@RequestParam Long boardId,
		@RequestParam Long pageSize,
		@RequestParam(required = false) Long lastArticleId
	) {
		return articleService.readAllInfiniteScroll(boardId, pageSize, lastArticleId);
	}

	@PostMapping("/v1/articles")
	public ArticleResponse create(@RequestBody ArticleCreateRequest request) {
		return articleService.create(request);
	}

	@PutMapping("/v1/articles/{articleId}")
	public ArticleResponse update(@PathVariable Long articleId, @RequestBody ArticleUpdateRequest request) {
		return articleService.update(articleId, request);
	}

	@DeleteMapping("/v1/articles/{articleId}")
	public void delete(@PathVariable Long articleId) {
		articleService.delete(articleId);
	}

	@GetMapping("/v1/articles/boards/{boardId}/count")
	public Long count(@PathVariable Long boardId) {
		return articleService.count(boardId);
	}
}
