package sam09;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filename;

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public void output(String msg) {
		try {
			FileWriter fw = new FileWriter(new File(filename));
			fw.write(msg);
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
