package com.company;

public class Application {

    public static void main(String[] args) {
        Book technicalBook = new TechBook(1, "Bible", "Matvey", Integer.MAX_VALUE, "religion");
        Book literatureBook = new LiteratureBook(2, "Aivengo", "W. Scott", 10);
        Book bestSeller = new BestSellerBook(3, "Harry Potter", "J. Rouling", 10, 3.5);

        Book[] books = {technicalBook, literatureBook, bestSeller};

        for (Book book : books) {
            System.out.println(book);
        }

        String str = "Book: " + technicalBook;
        System.out.println(str);

//        for (int i = 0; i < books.length; i++) {
//            System.out.println(books[i].describe());
//        }
    }
}
