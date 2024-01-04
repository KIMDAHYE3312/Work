package com.ohgiraffers.hw2.model.comparator;

import com.ohgiraffers.test.controller.BookManager;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Comparator;

public class DescCategory implements Comparator<BookDTO> {

    private int selectCategory;
    public DescCategory() {
        BookManager bookManager=new BookManager();
    }

    public DescCategory(int selectCategory) {
        this.selectCategory=selectCategory;
    }

    @Override
    public int compare(BookDTO book1, BookDTO book2) {
       return Integer.compare(book2.getCategory(),book1.getCategory());
    }
}
