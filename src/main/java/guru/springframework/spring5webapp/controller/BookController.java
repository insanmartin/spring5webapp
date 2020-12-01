package guru.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController
{
	private final BookRepository bookRespository;
	
	public BookController(BookRepository bookRespository) {
		super();
		this.bookRespository = bookRespository;
	}

	@RequestMapping( "/books" )
	public String getBooks( Model model )
	{
		model.addAttribute( "books", bookRespository.findAll() );
		return "books/list";
	}
	
	
}
