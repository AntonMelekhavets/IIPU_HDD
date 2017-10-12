package parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	enum Paterns {
		Model("Model Number:"), Serial("Serial Number:"), Firmware("Firmware Revision:"), Standarts("Supported:"), DMA(
				"DMA:"), PIO("PIO:");
		String template;

		Paterns(String template) {
			this.template = template;
		}

		public String toString() {
			return template;
		}
	}

	public static void parseHDDInfo(BufferedReader reader) throws IOException {
		String commandLine;
		Matcher matcher;
		while ((commandLine = reader.readLine()) != null) {
			for (Paterns template : Paterns.values()) {
				matcher = Pattern.compile(".+" + template.toString() + "(.+)").matcher(commandLine);
				if (matcher.matches()) {
					if(template == Paterns.Standarts)
						System.out.print("Standarts:");
					else
						System.out.print(template.toString());
					System.out.println(matcher.group(1));
				}
			}
		}
	}
}
