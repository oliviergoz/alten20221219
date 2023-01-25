package com.owliance.owlink.repository;

import com.owliance.owlink.vo.UsersVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositoryDAO extends JpaRepository<UsersVO, Long>, CrudRepository<UsersVO, Long>,
		PagingAndSortingRepository<UsersVO, Long>, QuerydslPredicateExecutor<UsersVO> {

	/**
	 * Permet de récupérer l'utilisateur par son prénom
	 * @param userNom nom de l'utilisateur
	 * @return {@link UsersVO}
	 */
	UsersVO findByUserNom(String userNom);

}
