package pack.aop2;

public class ArticleDao implements ArticleInter{
	
	@Override
	public void selectAll() {
		System.out.println("사원자료 전체 읽엇다고 치자");
		
	}

}
