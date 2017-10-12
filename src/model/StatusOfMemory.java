package model;

import java.io.File;

public class StatusOfMemory {
	private static long freeSpace;
	private static long totalSpace;
	private static long usingSpace;
	private static String driveName;
	
	public static void getSpace(String drive) {
		File linuxDrive = new File(drive);
		if(drive.contains("windows"))
			driveName = "c";
		else
			driveName = drive;
		totalSpace = linuxDrive.getTotalSpace();
		freeSpace = linuxDrive.getUsableSpace();
		usingSpace = totalSpace - freeSpace;
		printSpaces();
	}
	
	private static void printSpaces() {
		System.out.println("\nDrive: " + driveName);
		System.out.print("Using space (GB): ");
		System.out.format("%.3f%n", usingSpace/Math.pow(1024, 3));
		System.out.print("Total space (GB): ");
		System.out.format("%.3f%n", totalSpace/Math.pow(1024, 3));
		System.out.print("Free space (GB): ");
		System.out.format("%.3f%n", freeSpace/Math.pow(1024, 3));
	}
}
