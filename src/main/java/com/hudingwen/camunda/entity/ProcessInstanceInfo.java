package com.hudingwen.camunda.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * ClassName:ProcessInstanceInfo
 * Package:com.hudingwen.myspringbootflowable.entity
 * Description:描述
 *
 * @Date:2022/12/23 14:21
 * @Author:胡丁文
 * @E-mail:admin@aiwanyun.cn
 **/
@Data
@Setter
@Getter
public class ProcessInstanceInfo {
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String tenantId = "";
    protected String name;
    protected String description;
    protected String localizedName;
    protected String localizedDescription;
    protected Date lockTime;
    protected String lockOwner;
    protected boolean isActive = true;
    protected boolean isScope = true;
    protected boolean isConcurrent;
    protected boolean isEnded;
    protected boolean isEventScope;
    protected boolean isMultiInstanceRoot;
    protected boolean isCountEnabled;
    protected String eventName;
    protected String deleteReason;
    protected int suspensionState;
    protected String startActivityId;
    protected String startUserId;
    protected Date startTime;
    protected int eventSubscriptionCount;
    protected int taskCount;
    protected int jobCount;
    protected int timerJobCount;
    protected int suspendedJobCount;
    protected int deadLetterJobCount;
    protected int externalWorkerJobCount;
    protected int variableCount;
    protected int identityLinkCount;
    protected String processDefinitionId;
    protected String processDefinitionKey;
    protected String processDefinitionName;
    protected Integer processDefinitionVersion;
    protected String deploymentId;
    protected String activityId;
    protected String activityName;
    protected String processInstanceId;
    protected String businessKey;
    protected String businessStatus;
    protected String parentId;
    protected String superExecutionId;
    protected String rootProcessInstanceId;
    protected boolean forcedUpdate;
    protected String callbackId;
    protected String callbackType;
    protected String referenceId;
    protected String referenceType;
    protected String propagatedStageInstanceId;

    protected TaskInfo curTask;
}
