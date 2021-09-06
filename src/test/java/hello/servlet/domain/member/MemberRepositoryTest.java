package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//junit 5부터는 public 없어도 됨
class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void getInstance() {
    }

    @Test
    void save() {
        //given - 이런게 주어졌을때
        Member member = new Member();
        member.setId(1L);
        member.setAge(20);

        //when - 이걸 실행하면
        Member savedMember = memberRepository.save(member);

        //then - 결과
        Member findMember = memberRepository.findById(savedMember.getId());
        org.assertj.core.api.Assertions.assertThat(findMember).isEqualTo(savedMember);



    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {

        //given
        Member member1 = new Member("정해인", 34);
        Member member2 = new Member("구교환", 40);
        memberRepository.save(member1);
        memberRepository.save(member2);


        //when
        List<Member>result =  memberRepository.findAll();


        //then
        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);
        org.assertj.core.api.Assertions.assertThat(result).contains(member1, member2);
    }

    @Test
    void clearStore() {
    }
}