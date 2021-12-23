package com.peyman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.peyman.spring.context.ContextConfig;
import com.peyman.spring.context.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    ApplicationContext context;

    @Before
    public void init(){
//        context = new ClassPathXmlApplicationContext("applicationContext.xml");
            context = new AnnotationConfigApplicationContext(ContextConfig.class);
    }


    @Test
    public void checkSingletonInitStudent(){

        Student student = (Student) context.getBean("xyz");
        Student student2 = (Student) context.getBean("xyz");
        System.out.println(student);
        Assert.assertTrue(student == student2);
    }

    @Test
    public void sumMethodShouldSumTwoIntValues(){
        Student student = new Student();
        int actual =  student.sum(3,4);
        assertEquals(7, actual);
    }

    @Test
    public void studentMustHaveNameWhenInitialized(){
        Student actual = (Student) context.getBean("student");
        Assert.assertEquals("ali" , actual.getName());
    }

    @Test
    public void studentMustHaveBookWhenInitialized(){
        Student actual = (Student) context.getBean("student");
        Assert.assertNotEquals(null , actual.getBook());
    }



    @After
    public void resourceClose(){

    }

}
