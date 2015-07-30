package com.global3Dmod.ÇDmodels.form;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import com.global3Dmod.ÇDmodels.domain.Essence;

public class AddAdvertisementForm implements Essence {

	private String title;
	private String description;
	private String client;
	private String expirationDate;

	// file
	private MultipartFile advertisementPhoto;

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

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public MultipartFile getAdvertisementPhoto() {
		return advertisementPhoto;
	}

	public void setAdvertisementPhoto(MultipartFile advertisementPhoto) {
		this.advertisementPhoto = advertisementPhoto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((advertisementPhoto == null) ? 0 : advertisementPhoto
						.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((expirationDate == null) ? 0 : expirationDate.hashCode());
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
		AddAdvertisementForm other = (AddAdvertisementForm) obj;
		if (advertisementPhoto == null) {
			if (other.advertisementPhoto != null)
				return false;
		} else if (!advertisementPhoto.equals(other.advertisementPhoto))
			return false;
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddAdvertisementForm [title=" + title + ", description="
				+ description + ", client=" + client + ", expirationDate=" + expirationDate
				+ ", advertisementPhoto=" + advertisementPhoto + "]";
	}

	

}
