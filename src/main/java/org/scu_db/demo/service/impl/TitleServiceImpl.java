package org.scu_db.demo.service.impl;

import org.scu_db.demo.Repository.BookRepository;
import org.scu_db.demo.Repository.MemberRepository;
import org.scu_db.demo.Repository.TitleRepository;
import org.scu_db.demo.model.Title;
import org.scu_db.demo.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TitleService")
public class TitleServiceImpl implements TitleService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Override
    public List<Title> findAllTitles(){
        return titleRepository.findAll();
    }
}
