package manageuser.dao;

import java.util.List;

import manageuser.entities.Register;

public interface RegisterDao {
	
	
	public boolean addUserRegist(Register regiter);
	public boolean deleteUserRegist(int Id);
	public boolean updateUserRegist(Register register);
	public boolean addListUserRegist(List<Register> listRegister);
}
