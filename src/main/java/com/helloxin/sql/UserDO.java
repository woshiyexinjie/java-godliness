package com.helloxin.sql;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created by nandiexin on 2019/4/22.
 */
@ToString
@NoArgsConstructor
public class UserDO {

    public Integer id;

    public String userId;

    public String userName;

    public String userPhone;

    public String password;

    public Date dateCreate;

    public Date dateUpdate;


}
