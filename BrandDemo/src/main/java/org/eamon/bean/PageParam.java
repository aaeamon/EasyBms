package org.eamon.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParam {
    private Integer currentPage;
    private Integer pageSize;
    private String brandName;
    private String companyName;
    private Integer status;
}
