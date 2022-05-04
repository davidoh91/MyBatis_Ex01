package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
    private String userId;
    private String userName;
    private int userAge;
    private String userAddr;
}
