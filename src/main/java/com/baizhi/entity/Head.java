package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Head {
    @ExcelIgnore
    private String id;
    @Excel(name = "老师的头", needMerge = true)
    private String name;
}
