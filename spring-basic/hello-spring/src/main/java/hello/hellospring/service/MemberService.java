package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;


//    @Autowired // 의존관계 주입 DI
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /*
    회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복회원 x
//        Optional<Member> result = memberRepository.findByName(member.getName();
//        result.ifPresent(member1 -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다");
//        });
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                 .ifPresent(member1 -> {
                     throw new IllegalStateException("이미 존재하는 회원입니다");
                 });
    }

    /*
    전체 회원 조회회
    */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memeberId) {
        return memberRepository.findById(memeberId);
    }
}
