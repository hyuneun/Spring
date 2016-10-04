package pack.aop3;

import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao implements ArticleInter{
	
	@Override
	public void selectAll() {
		System.out.println("사원자료 전체 읽엇다고 치자");
		
	}

}
