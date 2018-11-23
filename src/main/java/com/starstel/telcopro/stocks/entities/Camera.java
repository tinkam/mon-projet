package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sosthene Nouebissi
 * @version 1.0
 * @created 13-oct.-2018 07:23:42
 */
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Camera implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "CAM_SEQ", allocationSize = 1, name = "cam_id")
    @GeneratedValue(generator = "cam_id")
	private Long id;
	private Double frontCamera;
	private Double backCamera;
	@OneToMany(cascade= CascadeType.ALL, mappedBy="camera")
	@JsonIgnore
	private Set<Portable> portableList = new HashSet<>();
	
	
	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime * result + ((backCamera == null) ? 0 : backCamera.hashCode());
		result = prime * result + ((frontCamera == null) ? 0 : frontCamera.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Camera other = (Camera) obj;
		if (backCamera == null) {
			if (other.backCamera != null)
				return false;
		} else if (!backCamera.equals(other.backCamera))
			return false;
		if (frontCamera == null) {
			if (other.frontCamera != null)
				return false;
		} else if (!frontCamera.equals(other.frontCamera))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Camera(Long id, Double frontCamera, Double backCamera) {
		super();
		this.id = id;
		this.frontCamera = frontCamera;
		this.backCamera = backCamera;
	}
	
	
}