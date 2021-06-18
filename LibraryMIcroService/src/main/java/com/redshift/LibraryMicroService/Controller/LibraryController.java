package com.redshift.LibraryMicroService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.redshift.LibraryMicroService.AOP.TrackTime;
import com.redshift.LibraryMicroService.Model.Book;
import com.redshift.LibraryMicroService.Model.Library;

@RestController
public class LibraryController 
{
	@Autowired
	RestTemplate template;
	
	List<Library> lib=List.of(
			new Library(1,"govt","hyd"),
			new Library(2,"private","vizag"),
			new Library(3,",limted","sdpt")
	);
	
	@GetMapping("/")
	public String welcom()
	{
		return "welcome";
	}
	
	@GetMapping("/library/{library_id}")
	@TrackTime
	public Library getLibrary(@PathVariable Integer library_id)
	{
		Library libr=this.lib.stream().filter(library-> library.getLibray_id().equals(library_id)).findAny().orElse(null);
		List<Book> books=template.getForObject("http://book-service/Book/Library/"+libr.getLibray_id(), List.class);
	//	Library libr=this.lib.stream().filter(library-> library.getLibray_id().equals(library_id)).findAny().orElse(null);
		libr.setBooks(books);
		return libr;
	}
	
	
}
