package pack.aop2;

public class LogicImpl implements LogicInter{
	private ArticleInter articleInter;
	
	public LogicImpl(ArticleInter articleInter) {
		this.articleInter = articleInter;
	}
	
	@Override
	public void selectData_process() {
		System.out.println("selectDataProcess 수행");
		articleInter.selectAll();
	}
	
}
