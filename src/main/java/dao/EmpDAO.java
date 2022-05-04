package dao;

import dto.EmpDTO;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import util.DbUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDAO {
    /*
        get all employee names
     */
    public void selectEnames() {
        //load, connect, execute, close
        SqlSession session = null;
        try {
            session = DbUtil.getSession();
            List<String> list = session.selectList("empMapper.selectEnames");
            System.out.println("개수 " + list.size());
            System.out.println("list = " + list);
        } finally {
            //close db session
            DbUtil.sessionClose(session);
        }
    }

    /*
       register an employee
     */
    public void insert(EmpDTO empDTO) {
        SqlSession session = null;
        boolean state = false;

        try {
            session = DbUtil.getSession();
            state = session.insert("empMapper.insert", empDTO) > 0 ? true : false;

            System.out.println("state after insertion sql : " + state);
        } finally {
            DbUtil.sessionClose(session, state);
        }

    }

    /*
        delete an employee
     */
    public void delete(int empNo) {
        SqlSession session = null;
        boolean state = false;

        try {
            session = DbUtil.getSession();
            state = session.delete("empMapper.delete", empNo) > 0 ? true : false;

            System.out.println("state after insertion sql : " + state);
        } finally {
            DbUtil.sessionClose(session, state);
        }
    }

    /*
       update an employee
    */
    public void update(EmpDTO empDTO) {
        SqlSession session = null;
        boolean state = false;

        try {
            session = DbUtil.getSession();
            state = session.update("empMapper.update", empDTO) > 0 ? true : false;

            System.out.println("state after insertion sql : " + state);
        } finally {
            DbUtil.sessionClose(session, state);
        }
    }

    /*
       select all
     */
    public void selectAll() {
        SqlSession session = null;
        try {
            session = DbUtil.getSession();

            //RowBounds( offset from the entire result rows, how many rows to get)
            List<EmpDTO> list = session.selectList("empSelectMapper.selectAll", null, new RowBounds(0, 5));

            for (EmpDTO emp : list) {
                System.out.println(emp);
            }
        } finally {
            DbUtil.sessionClose(session);
        }
    }

    /*
      select by employee id
     */
    public void selectByEmpNo(int empNo) {
        SqlSession session = null;
        try {
            session = DbUtil.getSession();
            session.selectOne("empSelectMapper.selectByEmpNo", empNo);
            System.out.println("emp= " + empNo);
        } finally {
            DbUtil.sessionClose(session);
        }
    }

    /*
      select by "less than" sal
     */
    public void selectLessThanSal(int sal) {
        SqlSession session = null;
        try {
            session = DbUtil.getSession();
            List<EmpDTO> list = session.selectList("empSelectMapper.selectLessThanSal", sal);

            for (EmpDTO emp : list) {
                System.out.println(emp);
            }
        } finally {
            DbUtil.sessionClose(session);
        }
    }

    /*
      select by "within" min and max sals
    */
    public void selectWithinSals(int min, int max) {
        SqlSession session = null;
        try {
            Map<String, Integer> map = new HashMap<>();
            // the keys must correspond to empSelectMapper xml's #{min} and #{max}
            map.put("min", min);
            map.put("max", max);

            session = DbUtil.getSession();
            List<EmpDTO> list = session.selectList("empSelectMapper.selectWithinSals", map);

            for (EmpDTO emp : list) {
                System.out.println(emp);
            }
        } finally {
            DbUtil.sessionClose(session);
        }
    }

    /*
      order by column (given as param)
     */
    public void selectOrder(String columnName) {
        SqlSession session = null;
        try {
            session = DbUtil.getSession();
            List<EmpDTO> list = session.selectList("empSelectMapper.selectOrder", columnName);

            for (EmpDTO emp : list) {
                System.out.println(emp);
            }
        } finally {
            DbUtil.sessionClose(session);
        }
    }

    /*
      order by column (given as param)
    */
    public void selectWhereMix(String keyfield, String keyword, int empno, int sal) {
        SqlSession session = null;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("keyfield", keyfield);
            map.put("keyword", keyword);
            map.put("EmpDTO", new EmpDTO(empno, null, null, sal, null));

            session = DbUtil.getSession();
            List<EmpDTO> list = session.selectList("empSelectMapper.selectWhereMix", map);

            for (EmpDTO emp : list) {
                System.out.println(emp);
            }
        }finally {
            DbUtil.sessionClose(session);
        }
    }

    /*
        select by job
     */
    public void selectByJob(String job) {
        SqlSession session = null;
        try {
            session = DbUtil.getSession();
            List<EmpDTO> list = session.selectList("empMapper.selectByJob", job);

            for (EmpDTO emp : list) {
                System.out.println(emp);
            }
        } finally {
            DbUtil.sessionClose(session);
        }
    }

    /*
        select all from Member table
     */
    public void memberSelectAll() {
        SqlSession session = null;
        try {
            session = DbUtil.getSession();
            List<EmpDTO> list = session.selectList("empMapper.memberSelectAll");

            for (EmpDTO emp : list) {
                System.out.println(emp);
            }
        } finally {
            DbUtil.sessionClose(session);
        }
    }


}//end of EmpDAO
