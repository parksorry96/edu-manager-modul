package com.bs.spring.member.model.dao;

import com.bs.spring.member.model.dto.Member;
import org.apache.ibatis.session.SqlSession;

public interface MemberDao {
    Member searchById(SqlSession session, String userId);
    int enrollMember(SqlSession session, Member member);
}
