package pack;

public class MyProcess {
	private String name;
	private Gugudan gugudan;
	private int dan;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGugudan(Gugudan gugudan) {
		this.gugudan = gugudan;
	}
	
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	@Override
	public String toString() {
		int[] ss = gugudan.guguCalc(dan);
		String str = "";
		for(int i = 0; i < ss.length; i++){
			str += dan + " * " + (i+1) + "=" + ss[i] + "\n";
		}
		return "작성자" + name + "\n" + dan + "단\n" + str;
	}
	
}
