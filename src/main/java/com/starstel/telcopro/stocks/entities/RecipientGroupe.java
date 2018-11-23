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

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RecipientGroupe implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "RECIPGRP_SEQ", allocationSize = 1, name = "recipgrp_id")
    @GeneratedValue(generator = "recipgrp_id")
	private Long id;
	private String name;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="groupe")
	@JsonIgnore
	private Set<Recipient> recipients = new HashSet<>();
}
