package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner
{
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData( AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository )
	{
		//super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println( "Started in Bootstrap" );
		
		Publisher penguin = new Publisher( "Penguin Books", "C/Bailarin", "Alicante", "CV", "03015" );
		publisherRepository.save( penguin );
		System.out.println( "Publisher Count: " + publisherRepository.count() );
		
		Author eric = new Author( "Eric", "Evans" );
		Book ddd = new Book( "Domain Driven Design", "123123" );
		eric.getBooks().add( ddd );
		ddd.getAuthors().add( eric );
		
		ddd.setPublisher( penguin );
		penguin.getBooks().add( ddd );
		
		authorRepository.save( eric );
		bookRepository.save( ddd );
		//necesario? --> por añadirlo en books Set?
		//publisherRepository.save( penguin );
		

		Author rod = new Author( "Rod", "Johnson" );
		Book noEJB = new Book( "J2EE Development without EJB", "5323423" );
		rod.getBooks().add( noEJB );
		noEJB.getAuthors().add( rod );

		noEJB.setPublisher( penguin );
		penguin.getBooks().add( noEJB );

		authorRepository.save( rod );
		bookRepository.save( noEJB );
		//necesario? --> por añadirlo en books Set?
		//publisherRepository.save( penguin );

		System.out.println( "Number of Books: " + bookRepository.count() );
		System.out.println( "Publisher Number of Books: " + penguin.getBooks().size() );
	}
	
	
}
