package com.kosa.myapp;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new GenericXmlApplicationContext("application-config.xml");
		IEmpService service = context.getBean(IEmpService.class);
		int empCount = service.getEmpCount();
		System.out.println("전체 사원의 수 : " + empCount);
		
		System.out.println("60번 부서 사원의 수 : " + service.getEmpCount(60));
		
//		System.out.println(service.getEmpList());
//		List<EmpVO> empList = service.getEmpList();
//		for(EmpVO emp : empList) {
//			System.out.println(emp);
//		}
		
//		System.out.println(service.getEmpInfo(103));
		
//		EmpVO emp = new EmpVO(300, "aaa", "bbb", "aabb", "010", new java.sql.Date(2020, 03, 20), 
//								"IT_PROG", 15000, 0.6, 103, 50);
//		try {
//			service.insertEmp(emp);
//			System.out.println("새로운 사원의 정보를 저장하였습니다.");
//		}catch(RuntimeException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		emp1.setEmail("A123456");
//		emp1.setSalary(15000);
//		try {
//			service.updateEmp(emp1); //사원 정보 수정
//		} catch (RuntimeException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(service.getEmpInfo(300));
		
//		System.out.println(service.getEmpInfo(300));
//		try {
//			service.deleteEmp(300, "aabb");
//			System.out.println("사원정보가 정상적으로 삭제되었습니다.");
//		} catch(RuntimeException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			System.out.println(service.getEmpInfo(300));
//		} catch(RuntimeException e) {
//			System.out.println("삭제할 사원정보가 없습니다.");
//		}
		
//		List<Map<String, Object>> deptInfo = service.getAllDeptId();
//		for (Map<String, Object> deptId : deptInfo) {
//			System.out.println(deptId.get("departmentId"));
//			System.out.println(deptId.get("departmentName"));
//		}
		
//		List<Map<String, Object>> jobInfo = service.getAllJobId();
//		for(Map<String, Object> jobId : jobInfo) {
//			System.out.println(jobId.get("jobId"));
//			System.out.println(jobId.get("jobTitle"));
//		}
		
		List<Map<String, Object>> managerInfo = service.getAllManagerId();
		for(Map<String, Object> managerId : managerInfo) {
			System.out.println(managerId.get("managerId"));
			System.out.println(managerId.get("firstName"));
		}
		
		context.close();
	}
}
