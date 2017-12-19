package com.app;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Emp_LO")
public class Employee {
	
	private int id;
	private String name;
	private char[] carr;
	private byte[] barr;
	
	@Id
	@Column(length=10)
	@Type(type="int")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(length=15)
	@Type(type="string")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Lob
	public char[] getCarr() {
		return carr;
	}
	public void setCarr(char[] carr) {
		this.carr = carr;
	}
	@Lob
	public byte[] getBarr() {
		return barr;
	}
	public void setBarr(byte[] barr) {
		this.barr = barr;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", carr=" + Arrays.toString(carr) + ", barr="
				+ Arrays.toString(barr) + "]";
	}

}
