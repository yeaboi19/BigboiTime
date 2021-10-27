import TerminalCommands.Commands;

import java.sql.SQLException;
import java.util.Scanner;

/*
TODO: in Commands think of what would getAll function return

 */


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mainString = input.nextLine();
        String[] array = mainString.split(" ");

        Commands com = new Commands(mainString);
        try {
            if (array[0].equalsIgnoreCase("create")) {
                com.createTable();
            } else if (array[0].equalsIgnoreCase("add")) {
                com.addThings();
            } else if (array[0].equalsIgnoreCase("get")) {
                com.getAll();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
// createTable
// addThings
// getAll


//create [TableName] [ColumnName]:[datatype] ...
//add [TableName] [info] ...
//get [TableName]