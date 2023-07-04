package board.demo.model;

import lombok.Builder;

public class Address {

    private Integer id; // 주소id

    private Integer userId; // 회원id

    private Integer zipCode; // 우편번호

    private String detailAddress; // 상세주소

    @Builder
    private Address (Integer id,
                     Integer userId,
                     Integer zipCode,
                     String detailAddress) {
        this.id = id;
        this.userId = userId;
        this.zipCode = zipCode;
        this.detailAddress = detailAddress;
    }
}
