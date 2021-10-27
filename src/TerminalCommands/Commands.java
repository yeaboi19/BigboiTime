package TerminalCommands;

import EpicSqlMoments.DataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Commands {
    DataConnect d = DataConnect.getInstance();
    Connection con = d.getConnection();
    String mainText;

    public Commands(String mainText) {
        this.mainText = mainText;
        PreparedStatement p = null;

        try {
            p = con.prepareStatement("USE samee");
            p.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int createTable() throws SQLException {
        String[] arr = mainText.split(" ");
        String mainCom = "CREATE TABLE "; // CREATE TABLE
        mainCom+=arr[1]+"(";              // [TableMain]
        for(int i=2;i<arr.length;i++){
            System.out.println("for func worked"); //  ------
            String[] temp = arr[i].split(":");
            if(temp[1].equalsIgnoreCase("varchar")){
                temp[1]+="(45)";
            }
            if(i==2){
                mainCom+="`"+temp[0]+"` "+temp[1];
            }else{
                mainCom+=", `"+temp[0]+"` "+temp[1];
            }
        }                                         // ------- [ColumnName] [datatype]
        mainCom+=")";
        PreparedStatement p = con.prepareStatement(mainCom);
        p.execute();
        return 0;
    }
    public int addThings(){ //Insert into epic Values("asdf",123);
        String[] arr = mainText.split(" ");
        String mainCom ="Insert into ";
        mainCom+=arr[1];
        for (int i = 2; i < arr.length; i++) {

        }
        return 0;
    }
    public void getAll(){
        String[] arr = mainText.split(" ");
        return;
    }
}
//create epic name1:varchar name2:int
//add epic asf 123
//get epic
// `
