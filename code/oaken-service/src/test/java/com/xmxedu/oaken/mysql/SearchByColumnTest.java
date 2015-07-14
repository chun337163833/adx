package com.xmxedu.oaken.mysql;

import java.sql.SQLException;

import org.junit.Test;

import com.xmxedu.oaken.sql.TbAppOsTable;

public class SearchByColumnTest {
  @Test
  public void mainTest(){
    try {
      TbAppOsTable.Row row = TbAppOsTable.getRow(TbAppOsTable.idColumnName, "2");
      if(null == row){
        return;
      }
      
      System.out.println(row.getType());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
