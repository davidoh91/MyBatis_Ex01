package main;

import dao.DynamicDAO;
import dto.EmpDTO;

import java.util.Arrays;

public class DynamicMainApp {

    public static void main(String[] args) {
        System.out.println("1. Dynamic Query - if -----------------------");

        // query based on name
        DynamicDAO.ifTest(new EmpDTO(0, "employee anonymous", null, 0, null));
        // query based on job
        DynamicDAO.ifTest(new EmpDTO(0, null, "progmr", 0, null));
        // query based on both name and job
        DynamicDAO.ifTest(new EmpDTO(0, "SMITH", "CLERK", 0, null));
        // query based on trim
        DynamicDAO.ifTest(new EmpDTO(0, null, "CLERK", 0, null));

        System.out.println("2. Dynamic Query - set -----------------------");
        DynamicDAO.setTest(new EmpDTO(9452, null, "prgmr", 0, null));
        DynamicDAO.setTest(new EmpDTO(9452, "Dave9999", "prgmr9999", 5000, null));
        DynamicDAO.setTest(new EmpDTO(9452, "Dave2142", "prgmr", 5000, null));

        System.out.println("3. Dynamic Query - forEach");
        DynamicDAO.forEachTest(Arrays.asList(9452, 7934));

    }

}
