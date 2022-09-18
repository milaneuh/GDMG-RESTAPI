package com.app.gdmg.servicesimpl;

import com.app.gdmg.models.UtilisateurBean;
import com.app.gdmg.entities.RolesEntity;
import com.app.gdmg.entities.UtilisateurEntity;
import com.app.gdmg.repository.RolesEntityRepository;
import com.app.gdmg.repository.UtilisateursEntityRepository;
import com.app.gdmg.services.UtilisateurService;
import com.app.gdmg.utils.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service @Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateursEntityRepository utilisateursEntityRepository;
    private  final RolesEntityRepository rolesEntityRepository;

    static Logger log = Logger.getLogger(UtilisateurServiceImpl.class.getName());

    @Override
    public ResponseEntity saveUser(UtilisateurBean user) throws Exception {
        log.log(Level.INFO,"saveUser(), User to save : "+user.toString());
        try {
            if (StringUtils.validateEmail(user.getMail())){
                if (StringUtils.validatePassword(user.getPassword())){
                    if (utilisateursEntityRepository.findByMail(user.getMail()) == null){
                        UtilisateurEntity userToSave = userToUserEntity(user);
                        userToSave.setRole(rolesEntityRepository.findByCode(user.getRole()));
                        utilisateursEntityRepository.save(userToSave);
                        return  new ResponseEntity(utilisateursEntityRepository.findByMail(user.getMail()), HttpStatus.OK);
                    }else {
                        log.info("The mail is already");
                        throw new Exception("The mail is already used");
                    }

                }else {
                    log.info("The password is invalid");
                    throw new Exception("The password is invalid");
                }
            }else {
                log.info("The mail is invalid");
                throw new Exception("The mail is invalid");
            }
        }catch (Exception event){
            throw new Exception(event);
        }
    }

    @Override
    public ResponseEntity deleteUser(UtilisateurBean utilisateurBean) throws Exception {
        log.log(Level.INFO,"deleteUser(), User to delete : "+ utilisateurBean.getMail());

            UtilisateurEntity userToDelete = utilisateursEntityRepository.findByMail(utilisateurBean.getMail());
            if (userToDelete != null){
                utilisateursEntityRepository.delete(userToDelete);
                return new ResponseEntity("OK",HttpStatus.OK);
            }else {
                throw new Exception("L'utilisateur n'existe pas");
            }
    }

    @Override
    public ResponseEntity updateUser(UtilisateurBean user) throws Exception {
        log.log(Level.INFO,"updateUser(), User to update"+user.toString());

        try {
            UtilisateurEntity userToUpdate = utilisateursEntityRepository.findByMail(user.getMail());
            userToUpdate.setMail(user.getMail());
            userToUpdate.setNom(user.getNom());
            userToUpdate.setPrenom(user.getPrenom());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setCivilite(user.getCivilite());
            userToUpdate.setTelephone(user.getTelephone());
            userToUpdate.setTelephone2(user.getTelephone2());
            utilisateursEntityRepository.save(userToUpdate);

            return new ResponseEntity(utilisateursEntityRepository.findByMail(user.getMail()),HttpStatus.OK);
        }catch (Exception event){
            event.printStackTrace();
            throw new Exception(event.getMessage());
        }
    }

    @Override
    public ResponseEntity getUser(String mail ) throws Exception {
        log.log(Level.INFO,"getUser(), getting a user with the mail :"+mail);
        UtilisateurEntity utilisateurEntity =  utilisateursEntityRepository.findByMail(mail);
        if(utilisateurEntity != null){
            return new ResponseEntity(utilisateurEntity,HttpStatus.OK);
        }
       else {
           throw new Exception("L'utilisateur ayant comme mail : "+mail+" n'existe pas");
        }
    }

    @Override
    public ResponseEntity getAllUsers() {
       return new ResponseEntity(utilisateursEntityRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity addRoleToUser(UtilisateurBean user, String roleCode) throws Exception {
        log.log(Level.INFO,"addRoleToUser(), Adding the role "+roleCode+" to the user : "+user.toString());
            UtilisateurEntity userToUpdate = utilisateursEntityRepository.findByMail(user.getMail());
            if (userToUpdate != null){
                RolesEntity roleToAdd = rolesEntityRepository.findByCode(roleCode);
                if (roleToAdd != null){
                    userToUpdate.setRole(roleToAdd);
                    return new ResponseEntity(utilisateursEntityRepository.findByMail(userToUpdate.getMail()), HttpStatus.OK);
                }  else {
                    throw new Exception("Le role n'existe pas");
                }
            }  else {
                throw new Exception("L'utilisateur n'existe pas");
            }



    }

    @Override
   public UtilisateurEntity userToUserEntity(UtilisateurBean user) {
        //String pw_hash = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
        return new UtilisateurEntity(
                user.getPassword(),
                HtmlUtils.htmlEscape(user.getMail()),
                HtmlUtils.htmlEscape(user.getCivilite()),
                HtmlUtils.htmlEscape(user.getNom()),
                HtmlUtils.htmlEscape(user.getPrenom()),
                user.getNewsletter(),
                HtmlUtils.htmlEscape(user.getTelephone()),
                HtmlUtils.htmlEscape(user.getTelephone2()),
                rolesEntityRepository.findByLabel(user.getRole())
        );
    }

    @Override
    public UtilisateurBean dbUserToUser(UtilisateurEntity user) {
        UtilisateurBean userToReturn = new UtilisateurBean(
                user.getPassword(),
                user.getMail(),
                user.getCivilite(),
                user.getNom(),
                user.getPrenom(),
                user.getNewsletter(),
                user.getTelephone(),
                user.getTelephone2(),
                rolesEntityRepository.findByCode(user.getRole().getCode()).getCode()
        );
        return userToReturn;
    }

    @Override
    public List<UtilisateurEntity> listUserToListDbUser(List<UtilisateurBean> users) {
        List<UtilisateurEntity> usersToReturn = new ArrayList<>();
        for(int i = 0; i< users.size();i++){
            usersToReturn.add(userToUserEntity(users.get(i)));
        }
        return usersToReturn;
    }

    @Override
    public List<UtilisateurBean> listDbUserToListUser(List<UtilisateurEntity> users) {
        List<UtilisateurBean> usersToReturn = new ArrayList<>();
        for(int i = 0; i< users.size();i++){
            usersToReturn.add(dbUserToUser(users.get(i)));
        }
        return usersToReturn;
    }

    public UtilisateurServiceImpl(UtilisateursEntityRepository utilisateursEntityRepository, RolesEntityRepository rolesEntityRepository) {
        this.utilisateursEntityRepository = utilisateursEntityRepository;
        this.rolesEntityRepository = rolesEntityRepository;
    }
}
