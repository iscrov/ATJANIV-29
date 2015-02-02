package ua.org.oa.grishin;

import java.util.Scanner;

public class AnalyzerText_v2 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		System.out.println("Äîáğî ïîæàëîâàòü â \"Àíàëèçàòîğ òåêñòà\"");
		System.out.println("Âûáåğèòå âàğèàíò àíàëèçà òåêñòà.");
		System.out.println("1 --> àíàëèç ôàéëà");
		System.out.println("2 --> àíàëèç ââåäåííîãî òåêñòà");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		switch (input.nextLine()) {
		case "1":
			consoleOutput();
			break;
		case "2":
			System.out.println("Vvedi stroky");
			sb.append(input.nextLine());
			break;
		default:
			break;
		}
		analyzeText();
	}

	private static void consoleOutput() {
		String str2 = "file.txt";
		Scanner scanner = new Scanner(AnalyzerText_v2.class.getResourceAsStream(str2));
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			System.out.println(nextLine);
			sb.append(nextLine);
		}
		scanner.close();
	}

	public static boolean checkWithAlgorithmSoglasnue(String userNameString) {
		//String validStr = "ÁáÂâÃãÄäÆæÇçÊêËëÌìÍíÏïĞğÑñÒòÔôÕõÖö×÷ØøÙùÜüÚúÉé";
		System.out.println(userNameString);
		String validStr = "áâãäæçêëìíïğñòôõö÷øùúüÁÂÃÄÆÇÉÊËÌÍÏĞÑÒÔÕÖ×ØÙÚÜBCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz";
		char[] symbols = userNameString.toCharArray();
		for(char c : symbols){
			if(validStr.indexOf(c) == -1) return false;
		}
		return true;
	}

	public static boolean checkWithAlgorithmGlasnue(String userNameString) {
		String validStr = "àå¸èîóûışÿ";
		char[] symbols = userNameString.toCharArray();
		for(char c : symbols){
			if(validStr.indexOf(c) == -1) return false;
		}
		return true;
		
	}

	public static void analyzeText() {
		int count = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (checkWithAlgorithmSoglasnue(sb.substring(i, i + 1))) {
				count++;
			}
		}

		System.out.println("Soglasnuh v tekste : " + count);

		int fount = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (checkWithAlgorithmGlasnue(sb.substring(i, i + 1))) {
				fount++;
			}
		}
		System.out.println("Glasnuh v tekste : " + fount);
	}
}
