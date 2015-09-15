package com.global3Dmod.ÇDmodel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "advertisement")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "Advertisement.findAll", query = "select a from Advertisement a", hints = {
				@QueryHint(name = "org.hibernate.cacheable", value = "true") }),
		@NamedQuery(name = "Advertisement.findOneById", query = "select a from Advertisement a where a.idAdvertisement = :idAdvertisement", hints = {
				@QueryHint(name = "org.hibernate.cacheable", value = "true") }) })
public class Advertisement implements Essence {

	/**
	 * 
	 */
	private static final long serialVersionUID = -680734570061371968L;

	@Id
	@Column(name = "id_advertisement")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdvertisement;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "client")
	private String client;

	@Column(name = "registration_date")
	private String registrationDate;

	@Column(name = "expiration_date")
	private String expirationDate;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "file_path")
	private String filePath;

	public Advertisement() {
		super();
	}

	public int getIdAdvertisement() {
		return idAdvertisement;
	}

	public void setIdAdvertisement(int idAdvertisement) {
		this.idAdvertisement = idAdvertisement;
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

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + idAdvertisement;
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Advertisement other = (Advertisement) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (idAdvertisement != other.idAdvertisement)
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Advertisement [idAdvertisement=" + idAdvertisement + ", title=" + title + ", description=" + description
				+ ", client=" + client + ", registrationDate=" + registrationDate + ", expirationDate=" + expirationDate
				+ ", fileName=" + fileName + ", filePath=" + filePath + "]";
	}

}
