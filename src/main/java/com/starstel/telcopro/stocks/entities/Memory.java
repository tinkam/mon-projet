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
 * @created 13-oct.-2018 07:24:02
 */
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Memory implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "MEMO_SEQ", allocationSize = 1, name = "memo_id")
    @GeneratedValue(generator = "memo_id")
	private Long id;
	private Double ram;
	private Double rom;
	private String brand;
	@OneToMany(cascade= CascadeType.ALL, mappedBy="memory")
	@JsonIgnore
	private Set<Portable> portableList = new HashSet<>();
	
	public Memory(Double ram, Double rom, String brand) {
		super();
		this.ram = ram;
		this.rom = rom;
		this.brand = brand;
	}
	
	
}