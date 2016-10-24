package pack.model;

import java.util.List;

public interface MemberInter {
	public List<MemberDto> getList();
	public void insert(MemberDto dto);
	public void update(MemberDto dto);
	public void delete(String no);
	public MemberDto getdata(String no);
}
