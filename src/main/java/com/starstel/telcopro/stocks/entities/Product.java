package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Product implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "STOCK_SEQ", allocationSize = 1, name = "stock_id")
    @GeneratedValue(generator = "stock_id")
	private Long id;
	private Double quantity;
	private Date dateCreation;
	private String designation;
	private String image;
	private Double priceUnit;
	private Double priceUnitWholesaler;
	private Double priceUnitSemiWholesaler;
	private Double stockMinim;
	private Double stockAlert;
	private Double volume;
	private String note;
	@ManyToOne
	private State state;
	@ManyToOne
	private Emplacement emplacement;
	@ManyToOne
	private MeasureUnit measureUnit;
	@ManyToOne
	private ProductCategory productCategory;
	@ManyToOne
	private AppColor appColor;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="product")
	private Set<MouvmentLine> mouvmentLines;
	@Override
	public String toString() {
		return "Product [id=" + id + ", quantity=" + quantity + ", dateCreation=" + dateCreation + ", designation="
				+ designation + ", image=" + image + ", priceUnit=" + priceUnit + ", priceUnitWholesaler="
				+ priceUnitWholesaler + ", priceUnitSemiWholesaler=" + priceUnitSemiWholesaler + ", stockMinim="
				+ stockMinim + ", stockAlert=" + stockAlert + ", volume=" + volume + ", note=" + note + ", state="
				+ state + ", emplacement=" + emplacement + ", measureUnit=" + measureUnit + ", productCategory="
				+ productCategory + ", appColor=" + appColor + ", mouvmentLines=" + mouvmentLines + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((priceUnit == null) ? 0 : priceUnit.hashCode());
		result = prime * result + ((priceUnitSemiWholesaler == null) ? 0 : priceUnitSemiWholesaler.hashCode());
		result = prime * result + ((priceUnitWholesaler == null) ? 0 : priceUnitWholesaler.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((stockAlert == null) ? 0 : stockAlert.hashCode());
		result = prime * result + ((stockMinim == null) ? 0 : stockMinim.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		Product other = (Product) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (priceUnit == null) {
			if (other.priceUnit != null)
				return false;
		} else if (!priceUnit.equals(other.priceUnit))
			return false;
		if (priceUnitSemiWholesaler == null) {
			if (other.priceUnitSemiWholesaler != null)
				return false;
		} else if (!priceUnitSemiWholesaler.equals(other.priceUnitSemiWholesaler))
			return false;
		if (priceUnitWholesaler == null) {
			if (other.priceUnitWholesaler != null)
				return false;
		} else if (!priceUnitWholesaler.equals(other.priceUnitWholesaler))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (stockAlert == null) {
			if (other.stockAlert != null)
				return false;
		} else if (!stockAlert.equals(other.stockAlert))
			return false;
		if (stockMinim == null) {
			if (other.stockMinim != null)
				return false;
		} else if (!stockMinim.equals(other.stockMinim))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}
	
	
}
