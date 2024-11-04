package com.emp.model;

import java.util.*;

public interface Platform_msgDAO_interface {
          public void insert(Platform_msgVO empVO);
          public void update(Platform_msgVO empVO);
          public void delete(Integer empno);
          public Platform_msgVO findByPrimaryKey(Integer empno);
          public List<Platform_msgVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
