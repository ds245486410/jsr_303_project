package com.hellen.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by DS on 2018/1/6.
 */
@AllArgsConstructor
@Getter@Setter@NoArgsConstructor
public class JsonResult implements Serializable {
    public static final Boolean SUCCESS = true;
    public static final Boolean FAILED  = false;

    private String msg;
    private boolean success = SUCCESS;
}
