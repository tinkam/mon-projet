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
 * @created 13-oct.-2018 07:23:47
 */
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Cpu implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "CPU_SEQ", allocationSize = 1, name = "cpu_id")
    @GeneratedValue(generator = "cpu_id")
	private Long id;
	private String brand;
	private Double frequency;
	@OneToMany(cascade= CascadeType.ALL, mappedBy="cpu")
	@JsonIgnore
	private Set<Portable> portableList = new HashSet<>();
	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
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
		Cpu other = (Cpu) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Cpu(String brand, Double frequency) {
		super();
		this.brand = brand;
		this.frequency = frequency;
	}
	
}