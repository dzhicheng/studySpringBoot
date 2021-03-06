package com.dongzhic.study.controller;

import com.dongzhic.study.service.GirlService;
import com.dongzhic.study.domain.Girl;
import com.dongzhic.study.domain.Result;
import com.dongzhic.study.repository.GirlRepository;
import com.dongzhic.study.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author dongzc
 * @date 2018/6/24 11:24
 */
@RestController
public class GirlController {

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;


    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/getGirlList")
    public List<Girl> getGirlList () {
        logger.info("getGirlList");
        return girlRepository.findAll();
    }

    /**
     * 添加女生
     * @return
     */
    @PostMapping(value = "addGirl")
    public Result<Girl> addGirl (@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查找一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/getGirl/{id}")
    public Girl getGirl (@PathVariable("id") Integer id) {
        return girlRepository.findById(id).get();
    }

    /**
     * 跟新一个女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "updateGirl/{id}")
    public Girl updateGirl (@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);

    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "deleteGirl/{id}")
    public void deleteGirl (@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "getGirlByAge/{age}")
    public List<Girl> getGirlByAge (@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "insertTwoGirl")
    public void insertTwoGirl () {
        girlService.insertTwoGirl();
    }

    @GetMapping(value = "getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) {
        girlService.getGirlByAge(id);
    }

    @GetMapping(value = "findByNameLike/{name}")
    public List<Girl> findByNameLike(@PathVariable("name") String name) {
        return girlRepository.findByNameLike('%'+name+'%');
    }

}
