package com.yishuifengxiao.common.crawler.domain.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * 测试输出数据
 *
 * @author yishui
 * @version 1.0.0
 * @date 2019年11月26日
 */
@ApiModel(value = "测试输出数据")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Valid
@Validated
public class SimulatorData implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3200425841448559923L;
    /**
     * 测试是否否成功，true表示成功，false表示失败
     */
    private Boolean success;
    /**
     * 输出数据，success为true时表示的是输出数据，success为false表示异常原因
     */
    private Object data;
}
