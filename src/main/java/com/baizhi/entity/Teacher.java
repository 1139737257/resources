package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baizhi.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget(value = "t")
public class Teacher {
    @Excel(name = "编号", needMerge = true)
    private String id;
    @Excel(name = "姓名", needMerge = true)
    private String name;
    @Excel(name = "性别", replace = {"男_1", "女_2"}, suffix = "生", needMerge = true)
    private String sex;
    @Excel(name = "生日", format = "yyyy-MM-dd", width = 20, needMerge = true)
    private Date bir;
    @ExcelEntity
    private Head head;
    @Excel(name = "头像", type = 2, width = 30, height = 20, needMerge = true)
    private String headImg;
    @ExcelCollection(name = "所属学员")
    private List<Student> list;
}
