package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    //회원의 아이디로 사용할 변수이다. static으로 지정해줘야 모든 Repository객체들이 공유할 수 있다.

    private static final MemberRepository instance = new MemberRepository();
    //싱글톤
    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {

    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //HashMap.value?
    }

    public void clearStore() {
        store.clear();
    }
}
