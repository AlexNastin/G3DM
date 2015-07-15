package com.global3Dmod.ÇDmodels.search.index;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BuildSearchIndex implements
		ApplicationListener<ContextRefreshedEvent> {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Create an initial Lucene index for the data already present in the
	 * database. This method is called during Spring's startup.
	 */
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		try {
			FullTextEntityManager fullTextEntityManager = Search
					.getFullTextEntityManager(entityManager);
			fullTextEntityManager.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			System.out
					.println("An error occurred trying to build the serach index: "
							+ e.toString());
		}
		return;
	}

}