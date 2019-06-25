package com.pulmuone.webservice.domain.items;

import com.pulmuone.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Items extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long goodsno;

    @Column(length = 100, nullable = false)
    private String goodsnm;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String chnnno;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String regid;

    @Builder
    public Items(String goodsnm, String chnnno, String content, String regid){
        this.goodsnm = goodsnm;
        this.chnnno = chnnno;
        this.content = content;
        this.regid = regid;
    }

}
