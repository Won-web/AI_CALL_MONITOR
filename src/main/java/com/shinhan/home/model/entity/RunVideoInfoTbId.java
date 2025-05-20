package com.shinhan.home.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class RunVideoInfoTbId implements Serializable {

    private Integer videoIdx;
    private String videoId;
}
