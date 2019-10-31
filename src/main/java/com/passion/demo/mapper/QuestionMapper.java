package com.passion.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.passion.demo.domain.Question;
import com.passion.demo.dto.QuestionDto;

import java.util.List;

/**
 * 提问的dao层
 *
 * @author passion
 */
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * 获取所有的提问数据
     *
     * @param pageDto
     * @return 返回提问的数据集合
     */
    List<QuestionDto> getQuestion(IPage<QuestionDto> pageDto);

}
