package com.boot.schedule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
 
@Component("iScheduleTaskDealSingleTest")
public class IScheduleTaskDealSingleTest implements IScheduleTaskDealSingle<TaskModel>{
 
    private static final Logger LOG = LoggerFactory.getLogger(IScheduleTaskDealSingleTest.class);
 
    /**
     * 获取任务的比较器,只有在NotSleep模式下需要用到
     * @return
     */
   @Override
    public Comparator<TaskModel> getComparator() {
        return null;
    }
   
   
   /**
    * taskParameter：对应控制台自定义参数，可自定义传入做逻辑上的操作
    *taskQueueNum：对应控制台任务项数量  相当于分页查询
    *taskItemList：集合中TaskItemDefine的id值对应任务项值，多线程处理时，根据任务项协调数据一致性和完整性
	*eachFetchDataNum：对应控制台每次获取数量，由于子计时单元开始后，会不断的去取数据进行处理，直到取不到数据子计时才停止，
	*等待下一个子计时开始。可以限制每次取数，防止一次性数据记录过大，内存不足。
	*ownSign：环境参数，一般没什么用
    */
    @Override
    public List<TaskModel> selectTasks(String taskParameter, String ownSign, int taskQueueNum,
            List<TaskItemDefine> taskItemList, int eachFetchDataNum) throws Exception {
        LOG.info("IScheduleTaskDealSingleTest配置的参数，taskParameter:{}，"+
            "ownSina:{}，taskQueueNum:{},taskItemList:{}, eachFetchDataNum:{}",
            taskParameter, ownSign, taskQueueNum, taskItemList, eachFetchDataNum);
    	
        LOG.info("IScheduleTaskDealSingleTest选择任务列表开始啦..........");
        List<TaskModel> models = new ArrayList<TaskModel>();
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest1"));
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest2"));
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest3"));
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest4"));
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest5"));
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest6"));
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest7"));
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest8"));
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest9"));
        models.add(new TaskModel(String.valueOf(System.currentTimeMillis()), "taosirTest10"));
        return models;
 
    }
    @Override
    public boolean execute(TaskModel model, String ownSign) throws Exception { 
        LOG.info("IScheduleTaskDealSingleTest执行开始啦.........." + new Date());
        System.out.println(model);
        return true;
 
    }
 
 
}
