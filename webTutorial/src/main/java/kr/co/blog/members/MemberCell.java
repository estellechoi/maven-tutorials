package kr.co.blog.members;
// 중첩 커맨드 
// Member 커맨드를 통해 MemberCell 커맨드에 접근하기 
// Member 커맨드 변수 자료형으로 List<MemberCell> 사용하였음 
public class MemberCell {
	
	private String cell1;
	private String cell2;
	private String cell3;
	
	public String getCell1() {
		return cell1;
	}
	public void setCell1(String cell1) {
		this.cell1 = cell1;
	}
	public String getCell2() {
		return cell2;
	}
	public void setCell2(String cell2) {
		this.cell2 = cell2;
	}
	public String getCell3() {
		return cell3;
	}
	public void setCell3(String cell3) {
		this.cell3 = cell3;
	}
	
	

}
