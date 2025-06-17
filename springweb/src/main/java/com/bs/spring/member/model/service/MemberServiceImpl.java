package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dao.MemberDao;
import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private SqlSession session;

    @Autowired
    private MemberDao dao;

    @Override
    public Member searchById(String userId) {
        Member member=dao.searchById(session, userId);
        return member;

    }

    @Override
    public int enrollMember(Member member) {
        return dao.enrollMember(session, member);
    }
}
