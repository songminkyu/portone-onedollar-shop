package seaung.onedollarshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seaung.onedollarshop.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
