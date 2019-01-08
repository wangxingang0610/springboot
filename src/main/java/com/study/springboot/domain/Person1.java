package com.study.springboot.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *      prefix = "person"：配置文件中哪个下面的所有属性进行一一映射
 *
 * @Component 只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能；
 *
 * @ConfigurationProperties(prefix = "person")默认从全局配置文件中获取值；
 *   //1、yml获取方式
 */
@Component
@Validated
public class Person1 {

    @Email
    @Value("${person1.lastName}")
    private String lastName;
//    @Value("${person1.age}")
//    @Value("${11*2}")
    private Integer age;
    @Value("${person1.yn}")
    private Boolean yn;
    @Value("${person1.birth}")
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person1{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", yn=" + yn +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getYn() {
        return yn;
    }

    public void setYn(Boolean yn) {
        this.yn = yn;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
