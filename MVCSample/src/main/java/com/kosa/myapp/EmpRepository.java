package com.kosa.myapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository implements IEmpRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int getEmpCount() {
		String sql = "SELECT count(*) FROM employees";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getEmpCount(int deptid) {
		String sql = "SELECT COUNT(*) FROM EMPLOYEES WHERE DEPARTMENT_ID=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, deptid);
	}

	private class EmpMapper implements RowMapper<EmpVO>{//내부 클래스

		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO emp = new EmpVO();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			return emp;
		} 
		
	}
	
	@Override
	public List<EmpVO> getEmpList() {
		String sql = "SELECT * FROM EMPLOYEES";
		return jdbcTemplate.query(sql, new EmpMapper());
	}

	@Override
	public EmpVO getEmpInfo(int empid) {
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		return jdbcTemplate.queryForObject(sql, new EmpMapper(), empid);
	}

	@Override
	public void updateEmp(EmpVO emp) {
		String sql = "UPDATE EMPLOYEES SET first_name=?, last_name=?, "
				+ "email=?, phone_number=?, "
				+ "hire_date=?, job_id=?, "
				+ "salary=?, commission_pct=?, "
				+ "manager_id=?, department_id=? "
				+ "where employee_id=?";
		jdbcTemplate.update(sql,	emp.getFirstName(),
									emp.getLastName(),
									emp.getEmail(),
									emp.getPhoneNumber(),
									emp.getHireDate(),
									emp.getJobId(),
									emp.getSalary(),
									emp.getCommissionPct(),
									emp.getManagerId(),
									emp.getDepartmentId(),
									emp.getEmployeeId());	
	}

	@Override
	public void insertEmp(EmpVO emp) {
		String sql = "INSERT INTO EMPLOYEES (employee_id, first_name, last_name, email, phone_number, "
				+ "hire_date, job_id, salary, commission_pct, manager_id, department_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, 	emp.getEmployeeId(),
									emp.getFirstName(),
									emp.getLastName(),
									emp.getEmail(),
									emp.getPhoneNumber(),
									emp.getHireDate(),
									emp.getJobId(),
									emp.getSalary(),
									emp.getCommissionPct(),
									emp.getManagerId(),
									emp.getDepartmentId());
	}

	@Override
	public void deleteJobHistory(int empid) {
		String sql = "DELETE job_history WHERE employee_id=?";
		jdbcTemplate.update(sql, empid);
	}

	@Override
	public void deleteEmp(int empid, String email) {
		String sql = "DELETE employees WHERE employee_id=? AND email=?";
		jdbcTemplate.update(sql, empid, email);
	}

	
	@Override
	public List<Map<String, Object>> getAllDeptId() {
		String sql = "SELECT department_id AS departmentId, "
				+ "			 department_name AS departmentName "
				+ "	  FROM departments";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		String sql = "SELECT job_id AS jobId, job_title AS jobTitle "
				+ "FROM jobs";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		String sql = "SELECT d.manager_id AS managerId, "
				+ " e.first_name as firstName "
				+ " FROM departments d JOIN employees e "
				+ " ON d.manager_id = e.employee_id"
				+ " ORDER BY d.manager_id";
		return jdbcTemplate.queryForList(sql);
	}

}
