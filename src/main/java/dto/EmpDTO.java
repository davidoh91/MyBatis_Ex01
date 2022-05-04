package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpDTO {
    private int empNo;
    private String empName;
    private String job;
    private int sal;
    private String hiredate;

}
