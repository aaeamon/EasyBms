package org.eamon.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 品牌实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    // id 主键
    private Integer id;
    // 品牌名称
    private String brandName;
    // 企业名称
    private String companyName;
    // 排序字段
    private Integer ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status;

    private String statusStr;

    public String getStatusStr() {
        return (this.status != null && this.status == 1) ? "启用" : "禁用";
    }
}
