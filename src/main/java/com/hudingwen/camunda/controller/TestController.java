package com.hudingwen.camunda.controller;

import com.hudingwen.camunda.entity.MessageModel;
import com.hudingwen.camunda.entity.ProcessDefinitionInfo;
import com.hudingwen.camunda.entity.ProcessInstanceInfo;
import com.hudingwen.camunda.entity.TaskInfo;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

@RestController
@Slf4j
@RequestMapping(value = "/api/test")
public class TestController {
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @Autowired
    private ProcessEngine processEngine;
    @GetMapping("/deploy")
    public String deplopy(String name){
        String path = "file/学生请假流程.bpmn20.xml";
        if(name != null && name != "") {
            path = "file/" + name;
        }
        Deployment deploy = repositoryService.createDeployment()
                .name("部署的第一个流程") // 定义部署文件的名称
                .addClasspathResource(path) // 绑定需要部署的流程文件
                .deploy();// 部署流程
        return deploy.getId() + ":" + deploy.getName();
    }

    @GetMapping(value = "/process")
    public MessageModel process() {
        List<ProcessDefinition> processList = repositoryService.createProcessDefinitionQuery().list();
        List<ProcessDefinitionInfo> ls = new ArrayList<ProcessDefinitionInfo>();
        for(ProcessDefinition processDefinition : processList){
            ProcessDefinitionInfo processDefinitionInfo = new ProcessDefinitionInfo();
            BeanUtils.copyProperties(processDefinition,processDefinitionInfo);
            ls.add(processDefinitionInfo);
            log.info("ProcessDefinition name = {},deploymentId = {}, processid = {}", processDefinition.getName(), processDefinition.getDeploymentId(),processDefinition.getId());
        }
        return MessageModel.Success("获取成功",ls);
    }
    /**
     * 启动流程的案例
     */
    @GetMapping("/start")
    public MessageModel startFlow(String processid){
        // 部署流程
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceById(processid);
        // 部署的流程实例的相关信息
        System.out.println("processInstance.getId() = " + processInstance.getId());
        System.out.println("processInstance.getProcessDefinitionId() = " + processInstance.getProcessDefinitionId());
        ProcessInstanceInfo processDefinitionInfo = new ProcessInstanceInfo();
        BeanUtils.copyProperties(processInstance,processDefinitionInfo);
        return MessageModel.Success("获取成功",processDefinitionInfo);//MessageModel
    }

    /**
     * 查询任务
     *    待办
     *
     *  流程定义ID:processDefinition : 我们部署流程的时候会，每一个流程都会产生一个流程定义ID
     *  流程实例ID:processInstance ：我们启动流程实例的时候，会产生一个流程实例ID
     */
    @GetMapping("/tasks")
    public MessageModel queryTask(String instanceid){
        List<Task> list = taskService.createTaskQuery()
                .processInstanceId(instanceid)
                //.taskAssignee("demo1")
                .list();
        List<TaskInfo> ls = new ArrayList<TaskInfo>();
        for (Task item:list ) {
            TaskInfo taskInfo = new TaskInfo();
            BeanUtils.copyProperties(item,taskInfo);
            ls.add(taskInfo);
            log.info("taskid = {}, name = {}, instanceid = {}",item.getId(),item.getName(),item.getProcessInstanceId());
        }
        return MessageModel.Success("获取成功",ls);//MessageModel
    }

    /**
     * 完成任务
     */
    @GetMapping("/finish")
    public MessageModel completeTask(String instanceid){

        Task task = taskService.createTaskQuery()
                .processInstanceId(instanceid)
                //.taskAssignee("demo")
                .singleResult();
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("outcome", "通过");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("小明1");
        strings.add("小明2");
        strings.add("小明3");
        myMap.put("managerUserIds", strings);
        taskService.complete(task.getId(),myMap);

        Task curTask = taskService.createTaskQuery().processInstanceId(instanceid).singleResult();

        TaskInfo taskInfo = new TaskInfo();
        BeanUtils.copyProperties(curTask,taskInfo);
        return MessageModel.Success("获取成功",taskInfo);//MessageModel
    }


}
