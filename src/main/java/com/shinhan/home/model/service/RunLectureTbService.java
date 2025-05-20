package com.shinhan.home.model.service;

import java.util.List;

import com.shinhan.home.model.dto.RunLectureTbDTO;

public interface RunLectureTbService {

    /**
     * 단일 강의 조회
     * @param lecIdx 강의 고유번호
     * @return RunLectureTbDTO
     */
    RunLectureTbDTO getLectureById(Integer lecIdx);

    /**
     * 강의 리스트 조회
     * @param dto 검색조건을 담은 DTO
     * @return List<RunLectureTbDTO>
     */
    List<RunLectureTbDTO> getLectureList(RunLectureTbDTO dto);
}
