package kr.ac.kopo.logintest.security;

import kr.ac.kopo.logintest.entity.ClubMember;
import kr.ac.kopo.logintest.entity.ClubMemberRole;
import kr.ac.kopo.logintest.repository.ClubMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.IntStream;

@SpringBootTest
public class ClubMemberTests {

    @Autowired
    private ClubMemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    public void insertDummies(){

        IntStream.rangeClosed(1, 100).forEach(i ->{
            ClubMember clubMember = ClubMember.builder()
                    .email("user" + i + "@kopo.ac.kr")
                    .name("사용자" + i)
                    .pawword(passwordEncoder.encode("1234"))
                    .fromSocial(false)
                    .build();

            clubMember.addMemberRole(ClubMemberRole.USER);

            if(i > 80){
                clubMember.addMemberRole(ClubMemberRole.MANAGER);
            }

            if(i > 90){
                clubMember.addMemberRole(ClubMemberRole.ADMIN);
            }

            repository.save(clubMember);
        });
    }
}
