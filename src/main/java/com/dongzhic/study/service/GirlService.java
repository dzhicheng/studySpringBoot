package com.dongzhic.study.service;

import com.dongzhic.study.enums.ResultEnum;
import com.dongzhic.study.exception.GirlException;
import com.dongzhic.study.repository.GirlRepository;
import com.dongzhic.study.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dongzc
 * @date 2018/6/25 10:17
 */
@Service
public class GirlService {

    @Autowired
    GirlRepository girlRepository;


    @Transactional(rollbackFor = Exception.class)
    public void insertTwoGirl () {
        Girl girlA = new Girl();
        girlA.setAge(10);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(20);
        girlB.setCupSize("B");
        girlRepository.save(girlB);
    }

    public void getGirlByAge (Integer id) {
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if(age < 13) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        } else if (age >= 13 && age <18) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查找女生
     * @param id 主键id
     * @return 女生
     */
    public Girl getGirlById(Integer id) {
        return girlRepository.findById(id).get();
    }
}
