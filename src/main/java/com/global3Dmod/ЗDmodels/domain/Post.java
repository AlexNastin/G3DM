package com.global3Dmod.ÇDmodels.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import com.global3Dmod.ÇDmodels.domain.Essence;

@Entity
@Indexed
@Table(name = "posts")
@NamedQueries({
		@NamedQuery(name = "Post.findAll", query = "select p from Post p"),
		@NamedQuery(name = "Post.findByDesigner", query = "select p from Post p join fetch p.category join fetch p.subcategory where p.user_idUser = :idUser and p.isDisplay in (1,2,3)"),
		@NamedQuery(name = "Post.findByUser", query = "select p from Post p where p.isDisplay = 3 and p.idPost in ((select l.post_idPost from Like l where user_idUser = :user_idUser))"),
		@NamedQuery(name = "Post.findOneById", query = "select p from Post p where p.idPost = :idPost"),
		@NamedQuery(name = "Post.findByCategory", query = "select p from Post p where p.category_idCategory = :category_idCategory and p.isDisplay = 3"),
		@NamedQuery(name = "Post.findBySubcategory", query = "select p from Post p where p.category_idCategory = :category_idCategory and p.subcategory_idSubcategory = :subcategory_idSubcategory and p.isDisplay = 3"),
		@NamedQuery(name = "Post.colPostByUser", query = "select count(p.user_idUser) from Post p where p.user_idUser = :user_idUser and p.isDisplay in (1,2,3)"),
		@NamedQuery(name = "Post.findByModerating", query = "select p from Post p join fetch p.category join fetch p.subcategory where p.isDisplay = 2"),
		@NamedQuery(name = "Post.findByRejecting", query = "select p from Post p join fetch p.category join fetch p.subcategory where p.isDisplay = 1")})

public class Post implements Essence {

	@Id
	@Column(name = "id_post")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPost;

	@Column(name = "user_id_user")
	private int user_idUser;

	@Column(name = "category_id_category")
	private int category_idCategory;

	@Column(name = "subcategory_id_subcategory")
	private int subcategory_idSubcategory;

	@Column(name = "number_post")
	@Field(store = Store.NO)
	private String numberPost;

	@Column(name = "disprogram_id_disprogram")
	private int disProgram_idDisProgram;

	@Column(name = "date_reg")
	private String dateReg;

	@Column(name = "date_update")
	private String dateUpdate;

	@Column(name = "title")
	@Field(store = Store.NO)
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "instruction")
	private String instruction;

	@Column(name = "is_display")
	private int isDisplay;

	@Column(name = "count_download")
	private int countDownload;

	@Column(name = "rating")
	private int rating;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "posts_has_technology", joinColumns = { @JoinColumn(name = "post_id_post") }, inverseJoinColumns = { @JoinColumn(name = "technology_id_technology") })
	private List<Technology> technologies;

	@OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private File file;
	
	@OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private RejectMessage rejectMessage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_user", insertable = false, updatable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "disprogram_id_disprogram", insertable = false, updatable = false)
	private DisProgram disProgram;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id_category", insertable = false, updatable = false)
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subcategory_id_subcategory", insertable = false, updatable = false)
	private Subcategory subcategory;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PostPhoto> postPhotos;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Like> likes;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Complain> complains;

	public Post() {
		super();
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public int getUser_idUser() {
		return user_idUser;
	}

	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	public int getCategory_idCategory() {
		return category_idCategory;
	}

	public void setCategory_idCategory(int category_idCategory) {
		this.category_idCategory = category_idCategory;
	}

	public int getSubcategory_idSubcategory() {
		return subcategory_idSubcategory;
	}

	public void setSubcategory_idSubcategory(int subcategory_idSubcategory) {
		this.subcategory_idSubcategory = subcategory_idSubcategory;
	}

	public int getDisProgram_idDisProgram() {
		return disProgram_idDisProgram;
	}

	public void setDisProgram_idDisProgram(int disProgram_idDisProgram) {
		this.disProgram_idDisProgram = disProgram_idDisProgram;
	}

	public String getDateReg() {
		return dateReg;
	}

	public void setDateReg(String dateReg) {
		this.dateReg = dateReg;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumberPost() {
		return numberPost;
	}

	public void setNumberPost(String numberPost) {
		this.numberPost = numberPost;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public int getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}

	public int getCountDownload() {
		return countDownload;
	}

	public void setCountDownload(int countDownload) {
		this.countDownload = countDownload;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public RejectMessage getRejectMessage() {
		return rejectMessage;
	}

	public void setRejectMessage(RejectMessage rejectMessage) {
		this.rejectMessage = rejectMessage;
	}

	public List<PostPhoto> getPostPhotos() {
		return postPhotos;
	}

	public void setPostPhotos(List<PostPhoto> postPhotos) {
		this.postPhotos = postPhotos;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DisProgram getDisProgram() {
		return disProgram;
	}

	public void setDisProgram(DisProgram disProgram) {
		this.disProgram = disProgram;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Complain> getComplains() {
		return complains;
	}

	public void setComplains(List<Complain> complains) {
		this.complains = complains;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + category_idCategory;
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + countDownload;
		result = prime * result + ((dateReg == null) ? 0 : dateReg.hashCode());
		result = prime * result
				+ ((dateUpdate == null) ? 0 : dateUpdate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((disProgram == null) ? 0 : disProgram.hashCode());
		result = prime * result + disProgram_idDisProgram;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + idPost;
		result = prime * result
				+ ((instruction == null) ? 0 : instruction.hashCode());
		result = prime * result + isDisplay;
		result = prime * result
				+ ((numberPost == null) ? 0 : numberPost.hashCode());
		result = prime * result
				+ ((postPhotos == null) ? 0 : postPhotos.hashCode());
		result = prime * result
				+ ((technologies == null) ? 0 : technologies.hashCode());
		result = prime * result + rating;
		result = prime * result
				+ ((subcategory == null) ? 0 : subcategory.hashCode());
		result = prime * result + subcategory_idSubcategory;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + user_idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (category_idCategory != other.category_idCategory)
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (countDownload != other.countDownload)
			return false;
		if (dateReg == null) {
			if (other.dateReg != null)
				return false;
		} else if (!dateReg.equals(other.dateReg))
			return false;
		if (dateUpdate == null) {
			if (other.dateUpdate != null)
				return false;
		} else if (!dateUpdate.equals(other.dateUpdate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (disProgram == null) {
			if (other.disProgram != null)
				return false;
		} else if (!disProgram.equals(other.disProgram))
			return false;
		if (disProgram_idDisProgram != other.disProgram_idDisProgram)
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (idPost != other.idPost)
			return false;
		if (instruction == null) {
			if (other.instruction != null)
				return false;
		} else if (!instruction.equals(other.instruction))
			return false;
		if (isDisplay != other.isDisplay)
			return false;
		if (numberPost == null) {
			if (other.numberPost != null)
				return false;
		} else if (!numberPost.equals(other.numberPost))
			return false;
		if (postPhotos == null) {
			if (other.postPhotos != null)
				return false;
		} else if (!postPhotos.equals(other.postPhotos))
			return false;
		if (technologies == null) {
			if (other.technologies != null)
				return false;
		} else if (!technologies.equals(other.technologies))
			return false;
		if (rating != other.rating)
			return false;
		if (subcategory == null) {
			if (other.subcategory != null)
				return false;
		} else if (!subcategory.equals(other.subcategory))
			return false;
		if (subcategory_idSubcategory != other.subcategory_idSubcategory)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (user_idUser != other.user_idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [idPost=" + idPost + ", user_idUser=" + user_idUser
				+ ", category_idCategory=" + category_idCategory
				+ ", subcategory_idSubcategory=" + subcategory_idSubcategory
				+ ", numberPost=" + numberPost + ", disProgram_idDisProgram="
				+ disProgram_idDisProgram + ", dateReg=" + dateReg
				+ ", dateUpdate=" + dateUpdate + ", title=" + title
				+ ", description=" + description + ", instruction="
				+ instruction + ", isDisplay=" + isDisplay + ", countDownload="
				+ countDownload + ", rating=" + rating + "]";
	}

}
