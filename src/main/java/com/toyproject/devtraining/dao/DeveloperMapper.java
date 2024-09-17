package com.toyproject.devtraining.dao;

import com.toyproject.devtraining.dto.DeveloperDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("DeveloperMapper")
public interface DeveloperMapper {
    // --- 개발자 생성
    void createDevelopers(DeveloperDTO developer);
    // --- 개발자 수 조회
    int getDevCount();
    // --- 개발자 다건 조회
    List<DeveloperDTO> getDevelopers();
    // --- 개발자 단건 조회
    DeveloperDTO getDeveloperDetail();
    // --- memberID로 조회
    List<DeveloperDTO> findByMemberId(@NotNull @Size(min = 3, max = 50, message = "memberId size must 3~50") String memberId);
}
