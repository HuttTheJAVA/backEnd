package chy.board.articleread.service.event.handler;

import java.time.Duration;

import org.springframework.stereotype.Component;

import chy.board.articleread.repository.ArticleIdListRepository;
import chy.board.articleread.repository.ArticleQueryModel;
import chy.board.articleread.repository.ArticleQueryModelRepository;
import chy.board.articleread.repository.BoardArticleCountRepository;
import chy.board.common.event.Event;
import chy.board.common.event.EventType;
import chy.board.common.event.payload.ArticleCreatedEventPayload;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ArticleCreatedEventHandler implements EventHandler<ArticleCreatedEventPayload> {
	private final ArticleIdListRepository articleIdListRepository;
	private final ArticleQueryModelRepository articleQueryModelRepository;
	private final BoardArticleCountRepository boardArticleCountRepository;

	@Override
	public void handle(Event<ArticleCreatedEventPayload> event) {
		ArticleCreatedEventPayload payload = event.getPayload();

		articleQueryModelRepository.create(
			ArticleQueryModel.create(payload),
			Duration.ofDays(1)
		);
		articleIdListRepository.add(payload.getBoardId(), payload.getArticleId(), 1000L);
		boardArticleCountRepository.createOrUpdate(payload.getBoardId(), payload.getBoardArticleCount());
	}

	@Override
	public boolean supports(Event<ArticleCreatedEventPayload> event) {
		return EventType.ARTICLE_CREATED == event.getType();
	}
}
