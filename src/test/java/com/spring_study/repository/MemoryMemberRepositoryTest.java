package com.spring_study.repository;

import com.spring_study.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();

    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        // 여기서 오류가 발생. 테스트 순서는 무작위이기 때문에
        // 독립적으로 각각의 테스트를 구현해야한다
        // -> 데이터 저장소를 클리어
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

        @Test
        public void findAll(){
            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("spring2");
            repository.save(member2);

            List<Member> result = repository.findAll();

            assertThat(result.size()).isEqualTo(2);

        }

}
