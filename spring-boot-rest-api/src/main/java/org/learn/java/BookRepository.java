package org.learn.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service
//@Repository
//@Component

public /*class*/ interface BookRepository extends JpaRepository<Book, Integer>{

/*	public static List<Book> BOOKS = new ArrayList<>(5);
	public static Map<Integer, Book> BOOKMAP = new HashMap<>(5);
	static {
		BOOKS.add(new Book(1001, "Julius Caesar"));
		BOOKS.add(new Book(1002, "A Tale of Two Cities"));
		BOOKS.add(new Book(1003, "Jungle Book"));
		BOOKS.add(new Book(1004, "Lion King"));
		BOOKS.add(new Book(1005, "Harry Potter"));

		for (Book book : BOOKS) {
			BOOKMAP.put(book.getId(), book);
		}
	}*/

	
}
