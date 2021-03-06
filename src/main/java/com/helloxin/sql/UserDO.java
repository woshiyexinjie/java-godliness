package com.helloxin.sql;

import lombok.Data;

import java.util.Date;

/**
 * Created by nandiexin on 2019/4/22.
 */
@Data
public class UserDO {

    private Integer id;

    private String userId;

    private String userName;

    private String userPhone;

    private String password;

    private Date dateCreate;

    private Date dateUpdate;

}
