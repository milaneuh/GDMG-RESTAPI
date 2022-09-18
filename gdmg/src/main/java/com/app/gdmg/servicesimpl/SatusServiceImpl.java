package com.app.gdmg.servicesimpl;

import com.app.gdmg.entities.StatusEntity;
import com.app.gdmg.models.StatusBean;
import com.app.gdmg.repository.StatusEntityRepository;
import com.app.gdmg.services.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class SatusServiceImpl implements StatusService {
    public final StatusEntityRepository statusEntityRepository;
    static Logger log = Logger.getLogger(SatusServiceImpl.class.getName());

    @Override
    public ResponseEntity saveStatus(StatusBean status) {
        StatusEntity statusEntity = statusBeanToStatusEntity(status);
        statusEntityRepository.save(statusEntity);
        return new ResponseEntity(statusEntityRepository.findByCode(statusEntity.getCode()),HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity updateStatus(StatusBean status) throws Exception {
        try {
            StatusEntity statusEntity = statusEntityRepository.findByCode(status.getCode());
            statusEntity.setLabel(status.getLabel());
            statusEntityRepository.save(statusEntity);
            return new ResponseEntity(statusEntityRepository.findByCode(statusEntity.getCode()),HttpStatus.OK) ;
        }catch (Exception e){
            throw  new Exception(e);
        }

    }

    @Override
    public ResponseEntity deleteStatus(StatusBean status) throws Exception {

        StatusEntity statusEntity = statusEntityRepository.findByCode(status.getCode());
        if(statusEntity != null) {
            statusEntityRepository.delete(statusEntity);
            StatusEntity result = statusEntityRepository.findByCode(status.getCode());
            return new ResponseEntity(result, HttpStatus.OK);
        }else {
            log.info(String.valueOf(statusEntity));
            throw new Exception("Ce staus n'existe pas");
        }
    }

    @Override
    public ResponseEntity getStatus(String code) {
        StatusEntity statusEntity = statusEntityRepository.findByCode(code);
        if(statusEntity != null) {
            return new ResponseEntity(statusEntity, HttpStatus.OK);
        }
        return new ResponseEntity("Il n'existe pas de status correspondants dans la bdd", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity getAllStatus() {
        List<StatusEntity> statusEntityList = statusEntityRepository.findAll();
        return new ResponseEntity(statusEntityList, HttpStatus.OK);
    }

    @Override
    public StatusEntity statusBeanToStatusEntity(StatusBean status) {
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setCode(status.getCode());
        statusEntity.setLabel(status.getLabel());

        return statusEntity;
    }

    @Override
    public StatusBean statusEntityToStatusBean(StatusEntity status) {
        StatusBean statusBean = new StatusBean();
        statusBean.setCode(status.getCode());
        statusBean.setLabel(status.getLabel());
        return statusBean;
    }

    @Override
    public List<StatusEntity> listStatusBeanToListStatusEntity(List<StatusBean> status) {
        List<StatusEntity> statusEntityList = new ArrayList<>();
        for(int i = 0;i < status.size(); i++){
            statusEntityList.add(statusBeanToStatusEntity(status.get(i)));
        }
        return statusEntityList;
    }

    @Override
    public List<StatusBean> listStatusEntityToListStatusBean(List<StatusEntity> status) {
        List<StatusBean> statusEntityList = new ArrayList<>();
        for(int i = 0;i < status.size(); i++){
            statusEntityList.add(statusEntityToStatusBean(status.get(i)));
        }
        return statusEntityList;
    }


    public SatusServiceImpl(StatusEntityRepository statusEntityRepository) {
        this.statusEntityRepository = statusEntityRepository;
    }

}
