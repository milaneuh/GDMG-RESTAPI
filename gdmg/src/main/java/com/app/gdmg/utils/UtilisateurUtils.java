package com.app.gdmg.utils;

import com.app.gdmg.models.UtilisateurBean;
import org.springframework.web.util.HtmlUtils;

public class UtilisateurUtils {
    public Boolean validateUserInfo(UtilisateurBean user){
        if (StringUtils.validateEmail(user.getMail()) && StringUtils.validatePassword(user.getPassword())){
            return true;
        }else {
            return false;
        }
    }

    public UtilisateurBean cleanUserChars(UtilisateurBean user){
        //String pw_hash = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
        return new UtilisateurBean(
                user.getPassword(),
                HtmlUtils.htmlEscape(user.getMail()),
                HtmlUtils.htmlEscape(user.getCivilite()),
                HtmlUtils.htmlEscape(user.getNom()),
                HtmlUtils.htmlEscape(user.getPrenom()),
                user.getNewsletter(),
                HtmlUtils.htmlEscape(user.getTelephone()),
                HtmlUtils.htmlEscape(user.getTelephone2()),
                user.getRole()
        );
    }

}
