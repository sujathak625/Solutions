import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadCSVFile implements ReadFileIF, GetSecondHighestIF {
	static ArrayList expenseArray;

	public static ArrayList getExpenseArray() {
		return expenseArray;
	}

	public static void setExpenseArray(ArrayList expenseArray) {
		ReadCSVFile.expenseArray = expenseArray;
	}

	private static String fileName = "Expense";
	private static String fileExtn = ".csv";
	private static String filePath = "C://Users//sujathak//Desktop//";

	public static void main(String[] arg) throws Exception {

		String inputFile = filePath + fileName + fileExtn;
		ReadCSVFile r = new ReadCSVFile();
		r.readFile(inputFile);

		r.get2ndHighest();

	}

	public static void displayExpensearray() {
		for (int i = 0; i < expenseArray.size(); i++) {
			System.out.print(expenseArray.get(i) + "\n");
		}
	}

	@Override
	public void readFile(String inputFile) {
		BufferedReader CSVFile = null;
		try {
			CSVFile = new BufferedReader(new FileReader(inputFile));

			String dataRow = CSVFile.readLine();
			int line = 0;
			expenseArray = new ArrayList();

			while (dataRow != null) {
				String[] dataArray = dataRow.split(",");

				if (line != 0) {
					expenseArray.add(dataRow);
				}
				dataRow = CSVFile.readLine();

				line++;
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				CSVFile.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	@Override
	public void get2ndHighest() {
		float highest = Integer.MIN_VALUE;
		float secondHighest =Integer.MIN_VALUE;
		int line = 0;
		String row = null;
		int rowNO = 0;
		while (line < expenseArray.size()) {
			row = (String) expenseArray.get(line);
			//System.out.println("rowNo" + line);
			String[] dataArray = row.split(",");
			float number = Float.parseFloat(dataArray[3]);			
			if (number > highest) {
				secondHighest = highest;
				highest = number;
				if(secondHighest > number){
					rowNO = line;
				}

			} else if (number > secondHighest) {
				secondHighest = number;
				rowNO = line;		
				if(secondHighest > number){
					rowNO = line;
				}
			}			
			++line;			
		}
		System.out.println("secondHighest" + secondHighest);
		System.out.println("rowNO" + rowNO);
		
	}
}
