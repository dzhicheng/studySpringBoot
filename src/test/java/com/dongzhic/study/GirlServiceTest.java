package com.dongzhic.study;

import com.dongzhic.study.domain.Girl;
import com.dongzhic.study.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dongzc
 * @date 2018/6/27 11:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void testGetGirlById () {
        Girl girl = girlService.getGirlById(1);
        Assert.assertEquals(new Integer(10), girl.getAge());
    }
}
