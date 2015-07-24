package com.global3Dmod.ÇDmodels.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.global3Dmod.ÇDmodels.dao.IPostDAO;
import com.global3Dmod.ÇDmodels.domain.Post;
import com.global3Dmod.ÇDmodels.exception.DaoException;
import com.global3Dmod.ÇDmodels.exception.ServiceException;
import com.global3Dmod.ÇDmodels.service.IAdminService;
import com.global3Dmod.ÇDmodels.service.IModeratorService;
import com.global3Dmod.ÇDmodels.service.ServiceParamConstant;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByCategory;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByCategoryDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDate;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDateDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDesigner;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDesignerDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDownloads;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByDownloadsDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByStatus;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByStatusDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsBySubcategory;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsBySubcategoryDesc;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitle;
import com.global3Dmod.ÇDmodels.sort.post.SortedPostsByTitleDesc;

@Service
public class ModeratorService implements IModeratorService{
	
	@Autowired
	private IPostDAO postDAO;

	@Override
	public List<Post> getPostsByModeratingForSort() throws ServiceException {
		List<Post> posts;
		try {
			posts = postDAO.selectPostsByModeratingForSort();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return posts;
	}
	
	@Override
	public ModelAndView setParamsForSort(ModelAndView modelAndView,
			String sort, boolean desc) throws ServiceException {
		if (ServiceParamConstant.CATEGORY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.CATEGORY_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.CATEGORY_DESC, false);
		}
		if (ServiceParamConstant.DATE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DATE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DATE_DESC, false);
		}
		if(ServiceParamConstant.DESIGNER.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.DESIGNER_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.DESIGNER_DESC, false);
		}
		if (ServiceParamConstant.SUBCATEGORY.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.SUBCATEGORY_DESC, true);
		} else {
			modelAndView
					.addObject(ServiceParamConstant.SUBCATEGORY_DESC, false);
		}
		if (ServiceParamConstant.TITLE.equalsIgnoreCase(sort) && !desc) {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, true);
		} else {
			modelAndView.addObject(ServiceParamConstant.TITLE_DESC, false);
		}
		return modelAndView;
	}
	
	@Override
	public List<Post> sortPosts(List<Post> posts, String sort, boolean desc)
			throws ServiceException {
		if (sort != null) {
			if (ServiceParamConstant.TITLE.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByTitleDesc());
				} else {
					Collections.sort(posts, new SortedPostsByTitle());
				}
			} else if (ServiceParamConstant.CATEGORY.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByCategoryDesc());
				} else {
					Collections.sort(posts, new SortedPostsByCategory());
				}
			} else if (ServiceParamConstant.SUBCATEGORY.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsBySubcategoryDesc());
				} else {
					Collections.sort(posts, new SortedPostsBySubcategory());
				}
			} else if (ServiceParamConstant.DATE.equals(sort)) {
				if (desc) {
					Collections.sort(posts, new SortedPostsByDateDesc());
				} else {
					Collections.sort(posts, new SortedPostsByDate());
				}
			} else if (ServiceParamConstant.DESIGNER.equals(sort)) {
				if(desc){
					Collections.sort(posts, new SortedPostsByDesignerDesc());
				} else {
					Collections.sort(posts, new SortedPostsByDesigner());
				}
			}
		}
		return posts;
	}

}
