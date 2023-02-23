package com.hudingwen.camunda.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.camunda.bpm.engine.form.FormProperty;

import java.util.Date;
import java.util.List;

/**
 * ClassName:TaskInfo
 * Package:com.hudingwen.myspringbootflowable.entity
 * Description:描述
 *
 * @Date:2022/12/23 10:15
 * @Author:胡丁文
 * @E-mail:admin@aiwanyun.cn
 **/
@Data
@Setter
@Getter
public class TaskInfo {
    private String id;
    private String name;
    public static final String DELETE_REASON_COMPLETED = "completed";
    public static final String DELETE_REASON_DELETED = "deleted";
    private static final long serialVersionUID = 1L;
    protected String owner;
    protected int assigneeUpdatedCount;
    protected String originalAssignee;
    protected String assignee;
    protected String parentTaskId;
    protected String localizedName;
    protected String description;
    protected String localizedDescription;
    protected int priority = 50;
    protected Date createTime;
    protected Date dueDate;
    protected int suspensionState;
    protected String category;
    protected boolean isIdentityLinksInitialized;
    protected String executionId;
    protected String processInstanceId;
    protected String processDefinitionId;
    protected String taskDefinitionId;
    protected String scopeId;
    protected String subScopeId;
    protected String scopeType;
    protected String scopeDefinitionId;
    protected String propagatedStageInstanceId;
    protected String taskDefinitionKey;
    protected boolean isCanceled;
    private boolean isCountEnabled;
    protected int variableCount;
    protected int identityLinkCount;
    protected int subTaskCount;
    protected Date claimTime;
    protected String tenantId;
    protected String eventName;
    protected String eventHandlerId;
    protected boolean forcedUpdate;
    protected List<FormProperty> formProperties;
}
