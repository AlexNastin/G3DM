package com.global3Dmod.ÇDmodel.search;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.lucene.search.Query;
import org.hibernate.Hibernate;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global3Dmod.ÇDmodel.domain.Post;

@Repository("jpaPostSearch")
@Transactional
public class PostSearch {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Post> search(String text) {

		FullTextEntityManager fullTextEntityManager = Search
				.getFullTextEntityManager(em);

		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
				.buildQueryBuilder().forEntity(Post.class).get();

		Query query = queryBuilder.keyword().onFields("title", "numberPost")
				.matching(text).createQuery();

		FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(
				query, Post.class);

		List<Post> posts = jpaQuery.getResultList();
		List<Post> finalPosts = new ArrayList<Post>();
		for (int i = 0; i < posts.size(); i++) {
			if (posts.get(i).getIsDisplay() == 3) {
				Hibernate.initialize(posts.get(i).getPostPhotos());
				Hibernate.initialize(posts.get(i).getTechnologies());
				Hibernate.initialize(posts.get(i).getUser());
				Hibernate.initialize(posts.get(i).getComments());
				finalPosts.add(posts.get(i));
			}
		}
		return finalPosts;
	}

}
