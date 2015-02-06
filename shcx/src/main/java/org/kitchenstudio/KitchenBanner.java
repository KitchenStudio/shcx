package org.kitchenstudio;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

public class KitchenBanner implements Banner{

	private String[] BANNER = {
"		 _______________ ",
"		 < KitchenStudio >",
"		  --------------- ",
"		         \\   ^__^",
"		          \\  (..)\\_______",
"		             (__)\\       )\\/\\",
"		                 ||----w |",
"		                 ||     ||"};

	@Override
	public void printBanner(Environment environment, Class<?> sourceClass,
			PrintStream out) {
		for (String line : BANNER) {
			out.println(line);
		}
		out.println();
	}

}
