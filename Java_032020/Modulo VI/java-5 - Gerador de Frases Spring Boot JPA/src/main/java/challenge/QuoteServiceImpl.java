package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class QuoteServiceImpl implements QuoteService {

	private final String TYPE_QUOTE = "Dialogue";

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {

		return repository
				.findAllByTypeIgnoreCase(TYPE_QUOTE)
				.map(this::randomList)
				.orElse(null);

	}

	@Override
	public Quote getQuoteByActor(String actor) {

		return repository
				.findByActorIgnoreCaseAndTypeIgnoreCase(actor, TYPE_QUOTE)
				.map(this::randomList)
				.orElse(null);

	}

	private Quote randomList(List<Quote> quoteList){
		return quoteList
				.get(new Random()
						.nextInt(quoteList.size())
				);
	}

}
