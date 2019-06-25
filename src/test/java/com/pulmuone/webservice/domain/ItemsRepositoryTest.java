package com.pulmuone.webservice.domain;

import com.pulmuone.webservice.domain.items.Items;
import com.pulmuone.webservice.domain.items.ItemsRepository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemsRepositoryTest {

    @Autowired
    ItemsRepository itemsRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        itemsRepository.deleteAll();
    }

    @Test
    public void 상품정보저장_불러오기() {
        //given
        itemsRepository.save(Items.builder()
                .goodsnm("풀무원 두부")
                .chnnno("234")
                .content("상품 테스트 본문")
                .regid("manani83")
                .build());

        //when
        List<Items> itemsList = itemsRepository.findAll();

        //then
        Items items = itemsList.get(0);
        assertThat(items.getGoodsnm(), is("풀무원 두부"));
        assertThat(items.getContent(), is("상품 테스트 본문"));
    }

    /*@Test
    public void BaseTimeEntity_등록 () {
        //given
        LocalDateTime now = LocalDateTime.now();
        itemsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());
        //when
        List<Posts> postsList = itemsRepository.findAll();

        //then
        Items items = postsList.get(0);
        assertTrue(items.getCreatedDate().isAfter(now));
        assertTrue(items.getModifiedDate().isAfter(now));
    }*/
}