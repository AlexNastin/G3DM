package com.global3Dmod.ÇDmodel.search.index;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BuildSearchIndex implements
		ApplicationListener<ContextRefreshedEvent> {

	private static Logger LOGGER = Logger.getLogger(BuildSearchIndex.class);

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
			LOGGER.error(
					"An error occurred trying to build the serach index: ", e);
		}
		return;
	}

}