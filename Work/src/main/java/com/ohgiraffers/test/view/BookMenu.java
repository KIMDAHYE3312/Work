package com.ohgiraffers.test.view;

import com.ohgiraffers.test.controller.BookManager;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {
    BookManager bookManager=new BookManager();
    public BookMenu() {

    }

    public void menu() {
        while(true) {
            Scanner sc=new Scanner(System.in);
            System.out.println("메뉴를 입력하세요 : ");
            System.out.println("1 : 도서 추가");
            System.out.println("2 : 제목으로 도서 검색");
            System.out.println("3 : 번호로 도서 검색");
            System.out.println("4 : 도서 목록 전체 출력");
            System.out.println("5 : 도서 삭제");
            System.out.println("6 : 카테고리 순으로 도서 정렬하기");
            System.out.println("0 : 종료");
            int no=sc.nextInt();
            switch(no) {
                case 1 :
                    bookManager.addBook(inputBook());
                    break;
                case 2 :
                    bookManager.searchBook(inputBookTitle());
                    break;
                case 3 :
                    System.out.print("검색 할 번호를 입력하세요 : ");
                    int index=sc.nextInt();
                    bookManager.printBook(index);
                    break;
                case 4 :
                    bookManager.displayAll();
                    break;
                case 5 :
                    System.out.print("삭제 할 도서 번호를 입력하세요 : ");
                    int deleteNum=sc.nextInt();
                    bookManager.deleteBook(deleteNum);
                    break;
                case 6 :
                    System.out.print("검색 할 도서 분류 코드를 입력하세요 : ");
                    int num=sc.nextInt();
                    System.out.println(bookManager.sortedBookList(num));
                    break;

                case 0 :
                    return;

            }
        }

    }

    public BookDTO inputBook() {
        BookDTO bookDTO=new BookDTO();
        Scanner sc=new Scanner(System.in);
        System.out.print("도서 번호를 입력하세요 : ");
        int bookNo=sc.nextInt();
        System.out.print("도서 분류 코드를 입력하세요(1: 인문, 2: 자연과학, 3: 의료, 4: 기타) : ");
        int category=sc.nextInt();
        sc.nextLine();
        System.out.print("제목을 입력하세요 : ");
        String title=sc.nextLine();
        System.out.print("저자를 입력하세요 : ");
        String author=sc.nextLine();
        bookDTO.setbNo(bookNo);
        bookDTO.setCategory(category);
        bookDTO.setTitle(title);
        bookDTO.setAuthor(author);
        return bookDTO;
    }

    public String inputBookTitle() {
        Scanner sc=new Scanner(System.in);
        System.out.print("검색할 도서 제목을 입력하세요 : ");
        String title=sc.next();
        return title;
    }

}
