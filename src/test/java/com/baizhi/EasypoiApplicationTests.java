package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.Head;
import com.baizhi.entity.Teacher;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasypoiApplicationTests {

    @Test
    public void contextLoads() throws IOException {
        Student student = new Student("01", "小东");
        Student student2 = new Student("02", "小西");
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        Head head = new Head("1", "铁头");
        Head head2 = new Head("2", "大头");


        Teacher teacher = new Teacher("1", "小黑", "1", new Date(), head, "E:\\164后期项目\\source\\easypoi\\src\\main\\webapp\\img\\A2.jpg", students);
        Teacher teacher2 = new Teacher("2", "小白", "2", new Date(), head2, "E:\\164后期项目\\source\\easypoi\\src\\main\\webapp\\img\\A2.jpg", students);

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher);
        teachers.add(teacher2);


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("164班人员", "老师和学生", "表1"),
                Teacher.class, teachers);

        workbook.write(new FileOutputStream(new File("D:/easy.xls")));

    }

    @Test
    public void contextLoads1() throws Exception {
        ImportParams params = new ImportParams();
        params.setTitleRows(2);
        params.setHeadRows(2);
        List<Teacher> list = ExcelImportUtil.importExcel(new FileInputStream(new File("D:/easy.xls")), Teacher.class, params);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }


    }


}
