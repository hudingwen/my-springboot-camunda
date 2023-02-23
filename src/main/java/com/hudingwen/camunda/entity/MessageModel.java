package com.hudingwen.camunda.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName:MessageModel
 * Package:com.hudingwen.myspringbootflowable.entity
 * Description:描述
 *
 * @Date:2022/12/23 16:52
 * @Author:胡丁文
 * @E-mail:admin@aiwanyun.cn
 **/
@Data
@Setter
@Getter
public class MessageModel {
    public static MessageModel Success(String msg,Object data){
        MessageModel messageModel = new MessageModel();
        messageModel.setStatus(200);
        messageModel.setSuccess(true);
        messageModel.setMsg(msg);
        messageModel.setData(data);
        return messageModel;
    }
    public static MessageModel Success(String msg){
        return MessageModel.Success(msg,null);
    }

    public static MessageModel Error(String msg,Object data){
        MessageModel messageModel = new MessageModel();
        messageModel.setStatus(500);
        messageModel.setSuccess(false);
        messageModel.setMsg(msg);
        messageModel.setData(data);
        return messageModel;
    }
    public static MessageModel Error(String msg){
        return MessageModel.Error(msg,null);
    }
    private int status = 200;
    private boolean success = true;
    private String msg;
    private Object data;
}
