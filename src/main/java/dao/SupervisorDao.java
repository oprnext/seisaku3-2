package dao;

import domain.Supervisor;

public interface SupervisorDao {
  
	void insert(Supervisor supervisor);
		
	Supervisor findByLoginAndPass(String supervisorId, String supervisorPass);
}
