
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import parsers.Parser;
import parsers.StatusOfMemory;

public class Main {

	public static void main(String[] args) {
		try {
			String linuxCommand = "hdparm -I /dev/sda";
			Process process = Runtime.getRuntime().exec(linuxCommand);
			process.waitFor();
			Parser.parseHDDInfo(new BufferedReader(new InputStreamReader(process.getInputStream())));
			process.destroy();
			process = Runtime.getRuntime().exec("df -m");
			process.waitFor();
			StatusOfMemory.getSpace(new BufferedReader(new InputStreamReader(process.getInputStream())));
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}