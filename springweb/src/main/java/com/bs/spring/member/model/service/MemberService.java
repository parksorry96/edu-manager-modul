package com.bs.spring.member.model.service;

import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;

public interface MemberService {
    Member searchById(String userId);
    int enrollMember(Member member);
}
