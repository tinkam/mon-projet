package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sosthene Nouebissi
 * @version 1.0
 * @created 11-oct.-2018 09:04:48
 */

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AppColor implements Serializable{

	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "APP_SEQ", allocationSize = 1, name = "app_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_id")
	private Long id;
	private String name;
	@OneToMany(cascade= CascadeType.ALL, mappedBy="appColor")
	@JsonIgnore
	private Set<Product> productsList;
	public AppColor(String name) {
		super();
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AppColor other = (AppColor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}