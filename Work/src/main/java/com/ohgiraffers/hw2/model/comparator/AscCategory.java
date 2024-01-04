package com.ohgiraffers.hw2.model.comparator;

import com.ohgiraffers.test.controller.BookManager;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Comparator;

public class AscCategory implements Comparator<BookDTO> {

    private int selectCategory;
    public AscCategory() {
        BookManager bookManager=new BookManager();
    }

    public AscCategory(int selectCategory) {
        this.selectCategory=selectCategory;
    }

    @Override
    public int compare(BookDTO book1, BookDTO book2) {
        return Integer.compare(book1.getCategory(), book2.getCategory());
    }
}



