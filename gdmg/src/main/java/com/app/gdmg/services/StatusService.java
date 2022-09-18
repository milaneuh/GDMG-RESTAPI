package com.app.gdmg.services;

import com.app.gdmg.entities.StatusEntity;
import com.app.gdmg.models.StatusBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StatusService {
    ResponseEntity saveStatus(StatusBean status);
    ResponseEntity updateStatus(StatusBean status) throws Exception;
    ResponseEntity deleteStatus(StatusBean status) throws Exception;
    ResponseEntity getStatus(String code);
    ResponseEntity getAllStatus();
    StatusEntity statusBeanToStatusEntity(StatusBean status);
    StatusBean statusEntityToStatusBean(StatusEntity status);
    List<StatusEntity> listStatusBeanToListStatusEntity(List<StatusBean> status);
    List<StatusBean> listStatusEntityToListStatusBean(List<StatusEntity> status);
}
