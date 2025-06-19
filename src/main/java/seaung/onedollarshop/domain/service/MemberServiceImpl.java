package seaung.onedollarshop.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seaung.onedollarshop.domain.entity.Member;
import seaung.onedollarshop.domain.repository.MemberRepository;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 회원 자동 생성
    @Override
    public Member autoRegister() {
        Member member = Member.builder()
                .username(UUID.randomUUID().toString())
                .email("example@example.com")
                .address("서울특별시 서초구 역삼동")
                .build();

        return memberRepository.save(member);
    }
}
