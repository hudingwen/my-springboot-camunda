package com.hudingwen.camunda.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * ClassName:ProcessDefinitionInfo
 * Package:com.hudingwen.myspringbootflowable.entity
 * Description:描述
 *
 * @Date:2022/12/23 13:51
 * @Author:胡丁文
 * @E-mail:admin@aiwanyun.cn
 **/
@Getter
@Setter
@Data
public class ProcessDefinitionInfo {
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String name;
    protected String localizedName;
    protected String description;
    protected String localizedDescription;
    protected String key;
    protected int version;
    protected String category;
    protected String deploymentId;
    protected String resourceName;
    protected String tenantId = "";
    protected Integer historyLevel;
    protected String diagramResourceName;
    protected boolean isGraphicalNotationDefined;
    protected Map<String, Object> variables;
    protected boolean hasStartFormKey;
    protected int suspensionState;
    protected boolean isIdentityLinksInitialized;
    protected String derivedFrom;
    protected String derivedFromRoot;
    protected int derivedVersion;
    protected String engineVersion;
}
