package action;

import java.util.Date;
import java.util.List;

import dao.GodessDao;
import model.Goddess;

public class GoddessAction {

	public static void main(String[] args) throws Exception {
		GodessDao g = new GodessDao();

		Goddess g1 = new Goddess();
		/*测试添加*/
//		g1.setUser_name("小喵");
//		g1.setAge(22);
//		g1.setSex(1);
//		g1.setBirthday(new Date());
//		g1.setEmail("111@aaa.com");
//		g1.setMobile("12345678765");
//		g1.setCreate_user("ADMIN");
//		g1.setUpdate_user("ADMIN");
//		g1.setIsdel(1);
//		g.addGoddess(g1);

		/*测试更新*/
//		g1.setUser_name("小喵");
//		g1.setAge(22);
//		g1.setSex(1);
//		g1.setBirthday(new Date());
//		g1.setEmail("31@aaa.com");
//		g1.setMobile("12345678765");
//		g1.setUpdate_user("ADMIN");
//		g1.setIsdel(1);
//		g1.setId(8);
//		g.updateGoddess(g1);
		
		
		/*测试删除*/
//		g.delGoddess(8);
		
		
		/*测试查询*/
		Goddess g2 = g.get(3);
		System.out.println(g2.toString());
	
//		List<Goddess> gs  = g.query();
//		for(Goddess goddess : gs){
//			System.out.println(goddess.getUser_name());
//		}
	}
}
