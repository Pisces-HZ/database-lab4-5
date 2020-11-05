package org.scu_db.demo.controller;

import org.scu_db.demo.model.Book;
import org.scu_db.demo.model.Member;
import org.scu_db.demo.model.Title;
import org.scu_db.demo.service.BookService;
import org.scu_db.demo.service.MemberService;
import org.scu_db.demo.service.TitleService;
import org.scu_db.demo.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private TitleService titleService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private BookService bookService;


    @RequestMapping("/1")
    public List<Integer> homework1(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询所有被借走图书的Book_ID。(对应第2题)
        //------------在此之下写下执行代码--------------
        List<Integer> bookId = new LinkedList<>();

        List<Book> book = bookService.findAllBooks();
        for(int i = 0; i < book.size(); i++) {
            if(book.get(i).getBorrowermemno() != null) {
                bookId.add(book.get(i).getBookId());
            }
        }
        //-----------在此之上写下执行代码---------------
	    return bookId;//TODO:修改返回值为bookId
        //return null;
    }

    @RequestMapping("/2")
    public List<Title> homework2(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询书名为”Iliad”或”Odyssey”的书目信息。(对应第4题)
        List<Title> titles = new LinkedList<>();

        //------------在此之下写下执行代码--------------
        List<Title> title = titleService.findAllTitles();
        for(int i = 0; i < title.size(); i++) {
            if(title.get(i).getName().equals("Iliad") || title.get(i).getName().equals("Odyssey")) {
                title.add(title.get(i));
            }
        }
        //-----------在此之上写下执行代码---------------
        return titles;//TODO:修改返回值为titles
    }


    @RequestMapping("/3")
    public Integer homework3(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询callnumber为”Call123”的图书有多少本。(对应第5题)
        Integer count = 0;
        //------------在此之下写下执行代码--------------
        List<Book> book = bookService.findAllBooks();
        for(int i = 0; i < book.size(); i++) {
            if(book.get(i).getCallnumber().equals("Call123")) {
                count++;
            }
        }
        //-----------在此之上写下执行代码---------------
        int books = count;
        return books;//TODO:修改返回值为books
    }

    @RequestMapping("/4")
    public List<String> homework4(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询本数不超过2本的图书的callnumber号。(对应第7题)
        List<String> callnumbers = new LinkedList<>();
        //------------在此之下写下执行代码--------------
        List<Book> book = bookService.findAllBooks();
        //用Map存储每个callnumber对应的本数
        Map<String,Integer> number = new LinkedHashMap<>();
        for(int i = 0; i < book.size(); i++) {
            String callnumber = book.get(i).getCallnumber();
            if(number.containsKey(callnumber)){
                Integer cn = number.get(callnumber);
                number.put(callnumber,++cn);
            }
            else{
                number.put(callnumber,1);
            }
        }
        for(Map.Entry<String, Integer> entry : number.entrySet()){
            if(entry.getValue() <= 2){
                callnumbers.add(entry.getKey());
            }
        }

        //-----------在此之上写下执行代码---------------
        return callnumbers;//TODO:修改返回值为books

    }


}
