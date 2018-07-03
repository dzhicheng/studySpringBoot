package com.dongzhic.study.repository;

import com.dongzhic.study.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author dongzc
 * @date 2018/6/24 11:25
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 通过年龄查找
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);

    List<Girl> findByNameLike(String name);

}
