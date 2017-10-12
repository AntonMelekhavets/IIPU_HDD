
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import model.StatusOfMemory;
import parsers.Parser;


public class Main {

	public static void main(String[] args) {
		try {
			String linuxCommand = "hdparm -I /dev/sda";
			Process process = Runtime.getRuntime().exec(linuxCommand);
			process.waitFor();
			Parser.parseHDDInfo(new BufferedReader(new InputStreamReader(process.getInputStream())));
			process.destroy();
			StatusOfMemory.getSpace("/");
			StatusOfMemory.getSpace("/windows");
			StatusOfMemory.getSpace("/d");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}