package com.ohgiraffers.test.controller;

//import com.ohgiraffers.hw2.model.comparator.AscCategory;
import com.ohgiraffers.hw2.model.comparator.AscCategory;
import com.ohgiraffers.hw2.model.comparator.DescCategory;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BookManager {
    ArrayList<BookDTO> bookList;
    public BookManager() {
        bookList=new ArrayList<>();
    }
    public void addBook(BookDTO bookDTO) {
        bookList.add(bookDTO);
    }

    public void searchBook(String title) {
        int bno=0;
        for(BookDTO book:bookList) {
            if(book.getTitle().equals(title)) {
                bno=book.getbNo();
                System.out.println(bno+"번 도서입니다.");
            }
            else{
                System.out.println("없는 도서입니다.");
                break;
            }

        }
    }
    public void printBook(int index) {
        BookDTO bookDTO=bookList.get(index);
        System.out.println("bookDTO = " + bookDTO);
    }

    public void displayAll() {
        System.out.println("도서 목록 = " + bookList);
    }

    public void deleteBook(int index) {
        for(BookDTO bookDTO:bookList) {
            if(bookDTO.getbNo()==index) {
                bookList.remove(bookDTO);
                break;
            }
        }
    }

    public void printBookList(ArrayList<BookDTO> book) {
        for(BookDTO bo:book) {
            System.out.println(bo);
        }
    }

    public ArrayList<BookDTO> sortedBookList(int select) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정렬 순서를 선택하세요(1 : 오름차순 , 2: 내림차순) : ");
        int sort = sc.nextInt();

        if (sort == 1) {
            Collections.sort(bookList,new AscCategory());
        } else if (sort == 2) {
            Collections.sort(bookList,new DescCategory());
        } else {
            System.out.println("잘못된 입력입니다.");
        }
        ArrayList<BookDTO> result=new ArrayList<>(bookList);

        return result;
    }
}
