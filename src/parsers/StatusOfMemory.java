package parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatusOfMemory {

	private static int freeSpace;
	private static int totalSpace;
	private static int usingSpace;

	public static void getSpace(BufferedReader reader) throws IOException {
		String commandLine;
		Matcher matcher;
		while ((commandLine = reader.readLine()) != null) {
			matcher = Pattern.compile("^(\\S+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+).+").matcher(commandLine);
			if (matcher.matches()) {
				usingSpace += Integer.parseInt(matcher.group(3));
				totalSpace += Integer.parseInt(matcher.group(2));
				freeSpace +=  Integer.parseInt(matcher.group(4));
			}
		}
		printSpaces();
	}

	private static void printSpaces() {
		System.out.println("\nDrive: ");
		System.out.print("Using space (GB): ");
		System.out.format("%.3f%n", usingSpace / 1024.0);
		System.out.print("Total space (GB): ");
		System.out.format("%.3f%n", totalSpace / 1024.0);
		System.out.print("Free space (GB): ");
		System.out.format("%.3f%n", freeSpace / 1024.0);
	}
}
