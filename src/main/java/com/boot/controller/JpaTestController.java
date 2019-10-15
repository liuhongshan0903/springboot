package com.boot.controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.boot.bean.BmsLocation;
import com.boot.dao.JpaDao;


/**
 * JPA 只适合做单表查询
 * @author liuhs
 *
 */
@RestController
public class JpaTestController {
	
	@Autowired
	private JpaDao jpaDao;
	
	/**
	 * testJpa
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/testJpa")
	public BmsLocation testJpa(@RequestBody BmsLocation dto){
		String id = dto.getId();
		System.out.println("testJpa====="+id);
		BmsLocation location = jpaDao.findOneById(id);
		System.out.println("testJpa======>"+location.toString());
		return location;
	}
	
	/**
	 * testJpa
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/testJpaDto")
	public BmsLocation testJpaDto(@RequestBody BmsLocation dto){
		String id = dto.getId();
		String parentId = dto.getParentId();
		System.out.println("testJpa===id=="+id+"====parentId=="+parentId);
		BmsLocation location = jpaDao.findOneByIdAndParentId(id,parentId);
		//System.out.println("testJpa===6666===>"+location.toString());
		return location;
	}
	
	
	/**
	 * testJpa
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/jpaListAll")
	public  List<BmsLocation> jpaListAll(){
		  List<BmsLocation> list  =  jpaDao.listAll();
		System.out.println("testJpa===6666===>"+list);
		return list;
	}
	

	    
	    public static void main(String[] args) {
	        
	        //1.创建 EntityManagerFactory
	        String persistenceUnitName = "jpa";
	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
	        
	        //2.创建 EntityManager
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        
	        //4.开启事务
	        EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	        
	        //5.进行持久化操作
	        BmsLocation location = new  BmsLocation ();
	        location.setApplyId("333");
	        location.setBmsStatus("0");
	        location.setName("66666666666");
	        entityManager.persist(location);
	        
	        //6.提交事务
	        transaction.commit();
	        
	        //7.关闭 EntityManager
	        entityManager.close();
	        
	        //8.关闭 EntityManagerFactory
	        entityManagerFactory.close();
	        
	        
	    }

}
