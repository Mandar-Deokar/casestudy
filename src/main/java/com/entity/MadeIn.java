package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "made_in")
public class MadeIn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "made_in_id")
	private int madeInId;
	@Column(name = "made_in_name", nullable = false)
	private String madeInName;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> product;	
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public MadeIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public MadeIn(int madeInId, String madeInName, List<Product> product) {
		super();
		this.madeInId = madeInId;
		this.madeInName = madeInName;
		this.product = product;
	}

	public int getMadeInId() {
		return madeInId;
	}

	public void setMadeInId(int madeInId) {
		this.madeInId = madeInId;
	}

	public String getMadeInName() {
		return madeInName;
	}

	public void setMadeInName(String madeInName) {
		this.madeInName = madeInName;
	}

	@Override
	public String toString() {
		return "MadeIn [madeInId=" + madeInId + ", madeInName=" + madeInName + "]";
	}
	
	
	
}
