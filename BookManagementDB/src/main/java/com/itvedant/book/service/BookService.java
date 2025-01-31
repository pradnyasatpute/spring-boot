package com.itvedant.book.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.book.dao.AddBookDAO;
import com.itvedant.book.dao.UpdateDAO;
import com.itvedant.book.entity.Book;
import com.itvedant.book.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	
	public Book create(AddBookDAO addBookDAO) {
		Book book = new Book();
		
		book.setBook_name(addBookDAO.getBook_name());
		book.setAuthor(addBookDAO.getAuthor());
		book.setPrice(addBookDAO.getPrice());
		this.bookRepository.save(book);
		
		return book;
	}
	
	public List<Book> readAllBooks(){
		List<Book> books = new ArrayList<Book>();
		
		books=this.bookRepository.findAll();
		return books;
	}
	public Book getBookById(Integer id) {
		Book book = new Book();
		book=this.bookRepository.findById(id).orElse(null);
		
		return book;
	}
	
	public Book updateBook(UpdateDAO updateDAO, Integer id) {
		Book book = new Book();
		book= this.getBookById(id);
		
		if(updateDAO.getBook_name() !=null) {
			book.setBook_name(updateDAO.getBook_name());
		}
		if(updateDAO.getAuthor() !=null) {
			book.setAuthor(updateDAO.getAuthor());
		}
		if(updateDAO.getPrice()!=null) {
			book.setPrice(updateDAO.getPrice());
		}
		
		
		this.bookRepository.save(book);
		return book;
		
	}
	
	public String delBook(Integer id) {
		this.bookRepository.deleteById(id);
		return "Deleted Successfully";
	}
	
		
		
	
}
