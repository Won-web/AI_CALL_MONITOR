package com.shinhan.home.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RunUserLectureTbId implements Serializable {
    @Column(name = "user_idx")
    private Integer userIdx;

    @Column(name = "lec_idx")
    private Integer lecIdx;
}
