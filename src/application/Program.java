package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		String path = "C:\\Users\\rebec\\Desktop\\Source.csv";
		List<Product> list = new ArrayList<>();
		List<String> productList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				productList.add(line);
				line = br.readLine();
			}

			for (String s : productList) {
				String name = s.substring(0, s.indexOf(","));
				double price = Double.parseDouble(s.substring(s.indexOf(",") + 1, s.lastIndexOf(",")));
				int quantities = Integer.parseInt(s.substring(s.lastIndexOf(",") + 1));

				Product p = new Product(name, price, quantities);
				list.add(p);
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		new File("C:\\Users\\rebec\\Desktop" + "\\Out").mkdir(); // cria a pasta Out
		path = "C:\\Users\\rebec\\Desktop\\Out\\Sumary.csv";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (Product p : list) {
				bw.write(p.toString());
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
