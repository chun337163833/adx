package com.xmxedu.oaken.sqlmodel;

import java.sql.*;
import java.util.*;
import com.javaranch.jenny.prod.*;

public class MockTbAppInfoTable extends TbAppInfoTable.Implementation
{
    public static class Row extends TbAppInfoTable.Row
    {
        public Connection update_con = null;
        public String update_column = null;
        public String update_searchText = null;
        public int update_calls = 0;

        public void update(Connection con, String column, String searchText) throws SQLException
        {
            update_con = con;
            update_column = column;
            update_searchText = searchText;
            update_calls++;
        }

        public void update(String column, String searchText) throws SQLException
        {
            update_column = column;
            update_searchText = searchText;
            update_calls++;
        }

        public void update(Connection con) throws SQLException
        {
            update_con = con;
            update_calls++;
        }

        public void update() throws SQLException
        {
            update_calls++;
        }

        public Connection insert_con = null;
        public int insert_calls = 0;
        public long insert_return = 0;

        public long insert(Connection con) throws SQLException
        {
            insert_con = con;
            insert_calls++;
            return insert_return;
        }

        public long insert() throws SQLException
        {
            insert_calls++;
            return insert_return;
        }
 
    }

    public Connection getRow_con = null;
    public String getRow_column = null;
    public String getRow_searchText = null;

    public long getRow_id = 0;

    public int getRow_calls = 0;
    public TbAppInfoTable.Row getRow_return = null;
    public List getRow_returns = new ArrayList(); // use this instead of getRow_return for multiple calls

    public TbAppInfoTable.Row getRow(Connection con, long id)
    {
        getRow_con = con;
        getRow_id = id;
        TbAppInfoTable.Row returnVal = getRow_return;
        if ((returnVal == null) && (getRow_calls < getRow_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row)getRow_returns.get(getRow_calls);
        }
        getRow_calls++;
        return returnVal;
    }

    public TbAppInfoTable.Row getRow(long id)
    {
        getRow_id = id;
        TbAppInfoTable.Row returnVal = getRow_return;
        if ((returnVal == null) && (getRow_calls < getRow_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row)getRow_returns.get(getRow_calls);
        }
        getRow_calls++;
        return returnVal;
    }

    public TbAppInfoTable.Row getRow()
    {
        TbAppInfoTable.Row returnVal = getRow_return;
        if ((returnVal == null) && (getRow_calls < getRow_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row)getRow_returns.get(getRow_calls);
        }
        getRow_calls++;
        return returnVal;
    }

    public TbAppInfoTable.Row getRow(Connection con, String column, String searchText) throws SQLException
    {
        getRow_con = con;
        getRow_column = column;
        getRow_searchText = searchText;
        TbAppInfoTable.Row returnVal = getRow_return;
        if ((returnVal == null) && (getRow_calls < getRow_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row)getRow_returns.get(getRow_calls);
        }
        getRow_calls++;
        return returnVal;
    }

    public TbAppInfoTable.Row getRow(String column, String searchText) throws SQLException
    {
        getRow_column = column;
        getRow_searchText = searchText;
        TbAppInfoTable.Row returnVal = getRow_return;
        if ((returnVal == null) && (getRow_calls < getRow_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row)getRow_returns.get(getRow_calls);
        }
        getRow_calls++;
        return returnVal;
    }

    public Connection getRows_con = null;
    public String getRows_column = null;
    public Object getRows_searchText = null; // could be a String or String[]
    public String getRows_whereClause = null;

    public long getRows_id = 0;

    public int getRows_calls = 0;
    public TbAppInfoTable.Row[] getRows_return = null;
    public List getRows_returns = new ArrayList(); // use this instead of getRows_return for multiple calls

    public TbAppInfoTable.Row[] getRows(Connection con, String column, String searchText) throws SQLException
    {
        getRows_con = con;
        getRows_column = column;
        getRows_searchText = searchText;
        TbAppInfoTable.Row[] returnVal = getRows_return;
        if ((returnVal == null) && (getRows_calls < getRows_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row[])getRows_returns.get(getRows_calls);
        }
        getRows_calls++;
        return returnVal;
    }

    public TbAppInfoTable.Row[] getRows(String column, String searchText) throws SQLException
    {
        getRows_column = column;
        getRows_searchText = searchText;
        TbAppInfoTable.Row[] returnVal = getRows_return;
        if ((returnVal == null) && (getRows_calls < getRows_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row[])getRows_returns.get(getRows_calls);
        }
        getRows_calls++;
        return returnVal;
    }

    public TbAppInfoTable.Row[] getRows(Connection con, String column, String[] searchText) throws SQLException
    {
        getRows_con = con;
        getRows_column = column;
        getRows_searchText = searchText;
        TbAppInfoTable.Row[] returnVal = getRows_return;
        if ((returnVal == null) && (getRows_calls < getRows_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row[])getRows_returns.get(getRows_calls);
        }
        getRows_calls++;
        return returnVal;
    }

    public TbAppInfoTable.Row[] getRows(String column, String[] searchText) throws SQLException
    {
        getRows_column = column;
        getRows_searchText = searchText;
        TbAppInfoTable.Row[] returnVal = getRows_return;
        if ((returnVal == null) && (getRows_calls < getRows_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row[])getRows_returns.get(getRows_calls);
        }
        getRows_calls++;
        return returnVal;
    }

    public TbAppInfoTable.Row[] getRows(Connection con, String whereClause) throws SQLException
    {
        getRows_con = con;
        getRows_whereClause = whereClause;
        TbAppInfoTable.Row[] returnVal = getRows_return;
        if ((returnVal == null) && (getRows_calls < getRows_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row[])getRows_returns.get(getRows_calls);
        }
        getRows_calls++;
        return returnVal;
    }

    public TbAppInfoTable.Row[] getRows(String whereClause) throws SQLException
    {
        getRows_whereClause = whereClause;
        TbAppInfoTable.Row[] returnVal = getRows_return;
        if ((returnVal == null) && (getRows_calls < getRows_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row[])getRows_returns.get(getRows_calls);
        }
        getRows_calls++;
        return returnVal;
    }

    public Connection getAllRows_con = null;
    public int getAllRows_calls = 0;
    public TbAppInfoTable.Row[] getAllRows_return = null;
    public List getAllRows_returns = new ArrayList(); // use this instead of getAllRows_return for multiple calls

    public TbAppInfoTable.Row[] getAllRows(Connection con) throws SQLException
    {
        getAllRows_con = con;
        TbAppInfoTable.Row[] returnVal = getAllRows_return;
        if ((returnVal == null) && (getAllRows_calls < getAllRows_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row[])getAllRows_returns.get(getAllRows_calls);
        }
        getAllRows_calls++;
        return returnVal;
    }

    public TbAppInfoTable.Row[] getAllRows() throws SQLException
    {
        TbAppInfoTable.Row[] returnVal = getAllRows_return;
        if ((returnVal == null) && (getAllRows_calls < getAllRows_returns.size()))
        {
            returnVal = (TbAppInfoTable.Row[])getAllRows_returns.get(getAllRows_calls);
        }
        getAllRows_calls++;
        return returnVal;
    }

    public Connection search_con = null;
    public String search_column = null;
    public Object search_searchText = null; // could be a String or String[]
    public String[] search_dataColumns = null;
    public String search_whereClause = null;
    public int search_calls = 0;
    public DBResults search_return = null;
    public List search_returns = new ArrayList(); // use this instead of search_return for multiple calls

    public DBResults search(Connection con, String column, String searchText, String[] dataColumns) throws SQLException
    {
        search_con = con;
        search_column = column;
        search_searchText = searchText;
        search_dataColumns = dataColumns;
        DBResults returnVal = search_return;
        if ((returnVal == null) && (search_calls < search_returns.size()))
        {
            returnVal = (DBResults)search_returns.get(search_calls);
        }
        search_calls++;
        return returnVal;
    }

    public DBResults search(String column, String searchText, String[] dataColumns) throws SQLException
    {
        search_column = column;
        search_searchText = searchText;
        search_dataColumns = dataColumns;
        DBResults returnVal = search_return;
        if ((returnVal == null) && (search_calls < search_returns.size()))
        {
            returnVal = (DBResults)search_returns.get(search_calls);
        }
        search_calls++;
        return returnVal;
    }

    public DBResults search(Connection con, String column, String[] searchText, String[] dataColumns) throws SQLException
    {
        search_con = con;
        search_column = column;
        search_searchText = searchText;
        search_dataColumns = dataColumns;
        DBResults returnVal = search_return;
        if ((returnVal == null) && (search_calls < search_returns.size()))
        {
            returnVal = (DBResults)search_returns.get(search_calls);
        }
        search_calls++;
        return returnVal;
    }

    public DBResults search(String column, String searchText[], String[] dataColumns) throws SQLException
    {
        search_column = column;
        search_searchText = searchText;
        search_dataColumns = dataColumns;
        DBResults returnVal = search_return;
        if ((returnVal == null) && (search_calls < search_returns.size()))
        {
            returnVal = (DBResults)search_returns.get(search_calls);
        }
        search_calls++;
        return returnVal;
    }

    public DBResults search(Connection con, String whereClause, String[] dataColumns) throws SQLException
    {
        search_con = con;
        search_whereClause = whereClause;
        search_dataColumns = dataColumns;
        DBResults returnVal = search_return;
        if ((returnVal == null) && (search_calls < search_returns.size()))
        {
            returnVal = (DBResults)search_returns.get(search_calls);
        }
        search_calls++;
        return returnVal;
    }

    public DBResults search(String whereClause, String[] dataColumns) throws SQLException
    {
        search_whereClause = whereClause;
        search_dataColumns = dataColumns;
        DBResults returnVal = search_return;
        if ((returnVal == null) && (search_calls < search_returns.size()))
        {
            returnVal = (DBResults)search_returns.get(search_calls);
        }
        search_calls++;
        return returnVal;
    }

    public DBResults search(Connection con, String[] dataColumns) throws SQLException
    {
        search_con = con;
        search_dataColumns = dataColumns;
        DBResults returnVal = search_return;
        if ((returnVal == null) && (search_calls < search_returns.size()))
        {
            returnVal = (DBResults)search_returns.get(search_calls);
        }
        search_calls++;
        return returnVal;
    }

    public DBResults search(String[] dataColumns) throws SQLException
    {
        search_dataColumns = dataColumns;
        DBResults returnVal = search_return;
        if ((returnVal == null) && (search_calls < search_returns.size()))
        {
            returnVal = (DBResults)search_returns.get(search_calls);
        }
        search_calls++;
        return returnVal;
    }

    public Connection update_con = null;
    public String update_column = null;
    public Object update_searchText = null; // could be a String or String[]
    public Map update_data = null;
    public int update_calls = 0;

    public void update(Connection con, String column, String searchText, Map data) throws SQLException
    {
        update_con = con;
        update_column = column;
        update_searchText = searchText;
        update_data = data;
        update_calls++;
    }

    public void update(String column, String searchText, Map data) throws SQLException
    {
        update_column = column;
        update_searchText = searchText;
        update_data = data;
        update_calls++;
    }

    public Connection delete_con = null;

    public long delete_id = 0;

    public String delete_column = null;
    public Object delete_searchText = null; // could be a String or String[]
    public int delete_calls = 0;

    public void delete(Connection con, long id) throws SQLException
    {
        delete_con = con;
        delete_id = id;
        delete_calls++;
    }

    public void delete(long id) throws SQLException
    {
        delete_id = id;
        delete_calls++;
    }

    public void delete(Connection con, String column, String searchText) throws SQLException
    {
        delete_con = con;
        delete_column = column;
        delete_searchText = searchText;
        delete_calls++;
    }

    public void delete(String column, String searchText) throws SQLException
    {
        delete_column = column;
        delete_searchText = searchText;
        delete_calls++;
    }


    public Connection insertAndGetID_con = null;
    public Map insertAndGetID_data = null;
    public int insertAndGetID_calls = 0;
    public long insertAndGetID_return = 0;

    public long insertAndGetID(Connection con, Map data) throws SQLException
    {
        insertAndGetID_con = con;
        insertAndGetID_data = data;
        insertAndGetID_calls++;
        return insertAndGetID_return;
    }

    public long insertAndGetID(Map data) throws SQLException
    {
        insertAndGetID_data = data;
        insertAndGetID_calls++;
        return insertAndGetID_return;
    }

}

