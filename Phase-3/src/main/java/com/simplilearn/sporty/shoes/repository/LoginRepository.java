package com.simplilearn.sporty.shoes.repository;

import com.simplilearn.sporty.shoes.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

	@Query ("select l from Login l where l.emailid = :emailid and l.password = :password and l.typeofuser=:typeofuser")
	public Login signIn(@Param ("emailid") String emailid,
			@Param("password") String password,
			@Param("typeofuser") String typeofuser);

}
