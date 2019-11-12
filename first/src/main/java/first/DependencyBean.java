package first;

public class DependencyBean {

	private InjectionBean injectionBean;
	
	// 생성자 
	public DependencyBean(InjectionBean injectionBean) {
		System.out.println("DependencyBean Constructor");
		this.injectionBean = injectionBean;
	}


	
	// setter
	public void setInjectionBean(InjectionBean injectionBean) {
		System.out.println("DependencyBean Setter of injectionBean");
		this.injectionBean = injectionBean;
	}
	
	public InjectionBean getInjectionBean() {
		return injectionBean;
	}
}
