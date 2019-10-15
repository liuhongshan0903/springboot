package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.bean.BmsLocation;

/**
 * 
 * 支持jpa 的服务基类
 * @author liuhs
 *
 */
public interface JpaDao extends JpaRepository<BmsLocation,String> {
	
	@Query("from BmsLocation as t where id = :id")
	BmsLocation findOneById(@Param("id")String id);
	
	@Query("from BmsLocation as t where id = :id  and parentId= :parentId")
	BmsLocation findOneByIdAndParentId(@Param("id")String id,@Param("parentId")String parentId);
	
	/**
	 * nativeQuery = true 指定可使用原生sql查询
	 * 
	 */
	@Query(nativeQuery = true ,value = "SELECT *  from  BMS_LOCATION" )
    List<BmsLocation> listAll();
	
	
}
