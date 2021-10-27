package TerminalCommands;

import EpicSqlMoments.DataConnect;

import java.sql.*;

public class Commands {
    DataConnect d = DataConnect.getInstance();
    Connection con = d.getConnection();

    public Commands() {
        PreparedStatement p;

        try {
            p = con.prepareStatement("USE samee");
            p.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createTable(String mainText) throws SQLException {//Create Table epic (`name1` varChar(45),`name2` int)
        String[] arr = mainText.split(" ");
        StringBuilder mainCom = new StringBuilder("CREATE TABLE "+arr[1]+"("); // CREATE TABLE [tableName]
        for(int i=2;i<arr.length;i++){//  ------
            String[] temp = arr[i].split(":");
            if(temp[1].equalsIgnoreCase("varchar")){
                temp[1]+="(45)";
            }
            if(i==2){
                mainCom.append("`"+temp[0]+"` "+temp[1]);
            }else{
                mainCom.append(", `"+temp[0]+"` "+temp[1]);
            }
        }                                         // ------- [ColumnName] [datatype]
        mainCom.append(")");
        System.out.println(mainCom);
        PreparedStatement p = con.prepareStatement(mainCom.toString());
        p.execute();
    }
    public void addThings(String mainText) throws SQLException { //Insert into epic Values("asdf",123);
        String[] arr = mainText.split(" ");
        StringBuilder mainCom = new StringBuilder("Insert into "+arr[1]+" Values(");
        for (int i = 2; i < arr.length; i++) {
            if(i==2){
                mainCom.append(arr[i]);
            }else{
                mainCom.append(", "+arr[i]);
            }
        }
        mainCom.append(")");
        System.out.println(mainCom);
        PreparedStatement p = con.prepareStatement(mainCom.toString());
        p.execute();
    }
    public void getAll(String mainText) throws SQLException {
        String[] arr = mainText.split(" ");
        PreparedStatement p = con.prepareStatement("Select * From "+arr[1]);
        ResultSet res = p.executeQuery();
        ResultSetMetaData rsmd = res.getMetaData();
        while (res.next()){
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(res.getString(i)+" ");
            }
            System.out.println();
        }
    }
}
//create epic name1:varchar name2:int
//add epic "asf" 123
//get epic
// `
