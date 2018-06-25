package com.dongzhic.study.Service;

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
}
