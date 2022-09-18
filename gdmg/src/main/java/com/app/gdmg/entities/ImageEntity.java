package com.app.gdmg.entities;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long image_id;

    private String image_src;
    private String image_desc;

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public String getImage_desc() {
        return image_desc;
    }

    public void setImage_desc(String image_desc) {
        this.image_desc = image_desc;
    }
}
