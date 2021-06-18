package com.redshift.LibraryMicroService.Model;

import java.util.List;

public class Library 
{
	Integer libray_id;
	String name;
	String address;
	List<Book> books;
	
	public Library(Integer libray_id, String name, String address) {
		super();
		this.libray_id = libray_id;
		this.name = name;
		this.address = address;
	}
	public Library(Integer libray_id, String name, String address, List<Book> books) {
		super();
		this.libray_id = libray_id;
		this.name = name;
		this.address = address;
		this.books = books;
	}
	public Integer getLibray_id() {
		return libray_id;
	}
	public void setLibray_id(Integer libray_id) {
		this.libray_id = libray_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	public Library() {
		//super();
	}
}
