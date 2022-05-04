package main;

import dao.EmpDAO;
import dto.EmpDTO;

public class EmpMainApp {
    public static void main(String[] args) {
        EmpDAO dao = new EmpDAO();

        /*
        System.out.println("1. Select Employee Names ----------------");
        dao.selectEnames();

        System.out.println("\n2. Register an Employee -----------------");
        dao.insert(new EmpDTO(9452, "Dave", "progmr", 4000, null));

        System.out.println("\n3. Delete an Employee ------------------");
        dao.delete(9452);
        */


        /*
        System.out.println("\n4. Update an Employee ------------------");
        dao.update(new EmpDTO(9452, "Dave", "programr", 4500, null));
        */

        /*

        System.out.println("\n5. Select All Employees");
        dao.selectAll();

        System.out.println("\n6. Select By empNo");
        dao.selectByEmpNo(7934);

        System.out.println("\n7. Select by Less Than Sal");
        dao.selectLessThanSal(2000);

        System.out.println("\n8. Within Min ~ Max Sals");
        dao.selectWithinSals(3000, 5000);

        System.out.println("\n9. Order by column (given as param)");
        dao.selectWhereMix("ename", "a", 7934, 3500);

        System.out.println("\n10. Select by job");
        dao.selectByJob("progmr");

         */

        System.out.println("\nMember Table 1. Select All from Member table");
        dao.memberSelectAll();

    }
}
