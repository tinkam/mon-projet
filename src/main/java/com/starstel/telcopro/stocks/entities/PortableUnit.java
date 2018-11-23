package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sosthene Nouebissi
 * @version 1.0
 * @created 13-oct.-2018 07:24:22
 */
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PortableUnit implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "PRODUCT_UNIT_SEQ", allocationSize = 1, name = "product_unit_id")
    @GeneratedValue(generator = "product_unit_id")
	private Long id;
	private String name;
}