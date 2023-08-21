package com.spring_study;


import com.spring_study.repository.JdbcMemberRepository;
import com.spring_study.repository.JdbcTemplateMemberRepository;
import com.spring_study.repository.MemberRepository;
import com.spring_study.repository.MemoryMemberRepository;
import com.spring_study.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
//         return new MemoryMemberRepository();
//         return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}


