package board.demo.dto;

import lombok.*;

@Data //Getter + Setter + ToString + EqualsAndHashCode + RequiredArgsConstructor
public class UserAddressDto {


    private Integer userId; // 회원id
    private String name; // 이름
    private String email; // 메일
    private Integer gender; // 성별
    private Integer addressId; // 주소id
    private Integer zipCode; // 우편번호
    private String detailAddress; // 상세주소

    @Builder
    public UserAddressDto(
            Integer userId,
            String name,
            String email,
            Integer gender,
            Integer addressId,
            Integer zipCode,
            String detailAddress) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.addressId = addressId;
        this.zipCode = zipCode;
        this.detailAddress = detailAddress;
    }
}
