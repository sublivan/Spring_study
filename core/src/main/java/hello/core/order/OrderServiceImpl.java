package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //생성자를 만들어준다.
public class OrderServiceImpl implements OrderService {

      // DIP 위반
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 생성자 주입
//    @Autowired //생성자가 하나일때는 생략해도 @Component를 통해 의존성주입이된다.
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // @Qualifire, 생성자 자동주입
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy
//            discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }


    //필드 주입
    //필드 인젝션은 안쓰는게 좋다.
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

   // 수정자 주입(setter 주입)
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy)  {
//        this.discountPolicy = discountPolicy;
//    }




    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
