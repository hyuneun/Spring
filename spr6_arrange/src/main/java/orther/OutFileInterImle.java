package orther;

import java.io.FileWriter;

public class OutFileInterImle implements OutFileInter{
	private String filePath;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void outFile(String msg) {
		//메시지를 파일로 출력
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(msg);
			writer.close();
			System.out.println("성공?!");
		} catch (Exception e) {
			
		}
	}
}
