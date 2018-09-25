package org.learn.java;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/rest")
public class BookRestController {

	//List<Book> books = BookRepository.BOOKS;
	//Map<Integer, Book> bookMap = BookRepository.BOOKMAP;
	
	@Autowired
	BookRepository bookRepository;

	@ApiOperation(value = "getALL() -> Get all the books item and return an array of books")
	@GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Book>> getAll() {

		// return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		return new ResponseEntity<Collection<Book>>(/*bookMap.values()*/ bookRepository.findAll(), HttpStatus.OK);

	}

	@ApiOperation(value = "getOne() -> Fetch a book by its id and return that book")
	@GetMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Book> getOne(@PathVariable Integer id) {
		//Book book = bookMap.get(id);
		Book book = bookRepository.findOne(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@ApiOperation(value = "createOrAdd() -> Create a book, save it to the repository and return void")
	@PostMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> createOrAdd(@RequestBody(required = true) Book book) {
		// books.add(book);
		//bookMap.put(book.getId(), book);
		bookRepository.save(book);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "update() -> Update an existting book, if not available then create a new book and save it to the repository")
	@PutMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> update(@RequestBody(required = true) Book book) {
/*		if (bookMap.containsKey(book.getId())) {
			bookMap.replace(book.getId(), book);
		} else {
			return createOrAdd(book);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);*/
		
		if(book.getId() != null) {
			book = bookRepository.save(book);
		}
		else {
			return createOrAdd(book);
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@ApiOperation(value = "delete() -> delete a book from the repository")
	@DeleteMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
/*		if (bookMap.containsKey(id)) {
			bookMap.remove(id);
		}*/
		bookRepository.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
