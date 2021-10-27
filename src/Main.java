import TerminalCommands.Commands;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mainString = input.nextLine();
        String[] array = mainString.split(" ");

        Commands com = new Commands();//Command klasis meoce lineze databases name shecvale
        while(true){
            try {
                if (array[0].equalsIgnoreCase("create")) {
                    com.createTable(mainString);
                } else if (array[0].equalsIgnoreCase("add")) {
                    com.addThings(mainString);
                } else if (array[0].equalsIgnoreCase("get")) {
                    com.getAll(mainString);
                }else if(array[0].equalsIgnoreCase("exit")){
                    break;
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            mainString = input.nextLine();
            array = mainString.split(" ");
        }

    }

}
// createTable
// addThings
// getAll


//create [TableName] [ColumnName]:[datatype] ...
//add [TableName] [info] ...
//get [TableName]