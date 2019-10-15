package com.boot.schedule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.bean.BmsUser;
import com.boot.service.UserService;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
 
@Component("iScheduleTaskDealSingleTest2")
public class IScheduleTaskDealSingleTest2 implements IScheduleTaskDealSingle<BmsUser>{
 
    private static final Logger LOG = LoggerFactory.getLogger(IScheduleTaskDealSingleTest2.class);
    
	@Autowired
    private UserService userService;
 
    /**
     * 获取任务的比较器,只有在NotSleep模式下需要用到
     * @return
     */
   @Override
    public Comparator<BmsUser> getComparator() {
        return null;
    }
 
   /**
    *taskParameter：对应控制台自定义参数，可自定义传入做逻辑上的操作
    *taskQueueNum：对应控制台任务项数量  相当于分页查询
    *taskItemList：集合中TaskItemDefine的id值对应任务项值，多线程处理时，根据任务项协调数据一致性和完整性
	*eachFetchDataNum：对应控制台每次获取数量，由于子计时单元开始后，会不断的去取数据进行处理，直到取不到数据子计时才停止，
	*等待下一个子计时开始。可以限制每次取数，防止一次性数据记录过大，内存不足。
	*ownSign：环境参数，一般没什么用
    */
    @Override
    public List<BmsUser> selectTasks(String taskParameter, String ownSign, int taskQueueNum,
            List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
        LOG.info("IScheduleTaskDealSingleTest配置的参数，taskParameter:{}，"+
            "ownSina:{}，taskQueueNum:{},taskItemList:{}, eachFetchDataNum:{}",
            taskParameter, ownSign, taskQueueNum, taskItemList, eachFetchDataNum);
    	
        LOG.info("IScheduleTaskDealSingleTest选择任务列表开始啦..........");
        List<BmsUser> result = new ArrayList<BmsUser>();
        
        //任务数为0直接返回
        if (taskItemList.size() == 0) {
            return result;
        }
        // 任务项数量 查询条件
        StringBuilder conditionSql = new StringBuilder();
        
        // 任务项 条件值
        List<Object> conditions = new ArrayList<Object>();
        conditions.add(taskQueueNum);
        for (int i = 0; i < taskItemList.size(); i++) {
            conditions.add(taskItemList.get(i).getTaskItemId());
            conditionSql.append("?");
            if(i<taskItemList.size()-1) {
                conditionSql.append(",");
            }   
        }
        LOG.info("conditions---" + conditions);
        LOG.info("taskQueueNum---" + taskQueueNum);
        conditions.add(taskQueueNum);
        
        try {  
            result = userService.findAllUser();
        } catch (Exception e) {
        	LOG.error("selectTasks error!", e);
        } 
        return result;
    }
    
    
    /**
     * 解析每一个list集合的元素，执行操作
     */
    @Override
    public boolean execute(BmsUser model, String ownSign) throws Exception { 
        LOG.info("IScheduleTaskDealSingleTest执行开始啦.........." + new Date());
        System.out.println(model.toString());
        return true;
 
    }
 
 
}
