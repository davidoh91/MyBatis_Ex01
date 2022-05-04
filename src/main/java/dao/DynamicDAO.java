package dao;

import dto.EmpDTO;
import org.apache.ibatis.session.SqlSession;
import util.DbUtil;

import java.util.List;

public class DynamicDAO {
    /*
        Dynamic Query - if, where, trim
     */
    public static void ifTest(EmpDTO empDTO) {
        SqlSession session = null;

        try {
            session = DbUtil.getSession();
            List<EmpDTO> list = session.selectList("dynamicMapper.ifSelect", empDTO);

            for(EmpDTO e : list) {
                System.out.println(e);
            }
        }finally {
            DbUtil.sessionClose(session);
        }
    }

    /*
        Dynamic Query - update & set
     */
     public static void setTest(EmpDTO empDTO) {
        SqlSession session = null;
        boolean state = false;

         try {
             session = DbUtil.getSession();
             state = session.update("dynamicMapper.ifSelect", empDTO) > 0 ? true : false;

             System.out.println("update result : " + state);
         }finally {
             DbUtil.sessionClose(session, state);
         }
     }

     /*
        forEach test
      */
     public static void forEachTest(List<Integer> empList) {
        SqlSession session = null;
        try {
            session = DbUtil.getSession();
            List<EmpDTO> list = session.selectList("dynamicMapper.forEachTest", empList);

            for(EmpDTO e : list) {
                System.out.println(e);
            }
        }finally {
            DbUtil.sessionClose(session);
        }

     }


}
