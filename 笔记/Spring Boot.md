
------------------------------------------------------------------------------------------------------------------------------
新建项目：

1.
    file ---> project ---> Spring Initializr

2.
    选择jdk、package、合适的依赖、项目路径


coding:

注入值的方式1，@ConfigurationProperties:  

@Component
@ConfigurationProperties(prefix = "person")
xxxClass

1.Person.java、Dog.java

        //@Component 为了使xx类加入spring的管理中
        
        @Component
        @ConfigurationProperties(prefix = "person")
        public class Person {
            private String lastName;
            private Integer age;
            private Boolean yn;
            private Date birth;
            private Map<String,Object> maps;
            private List<Object> lists;  
            private Dog dog;
            //省略set、get、toString
            
        }
        
        
        public class Dog {
            private String name;   
            private Integer age;
            //省略set、get、toString
        }
    
2.application.yml或application.properties（两种注入方式与数据文件无关）
        
        server:
          port: 8081
        
        person:
            lastName: zhangsan
            age: 10
            yn: false
            birth: 2019/01/02
            maps: {k1:v1 , k2:11}
            lists:
              - a
              - c
              - d
            dog:
              name: 阿旺
              age: 2

3.测试

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class SpringBoot02ConfigApplicationTests {
    
        @Autowired
        Person person;
    
        @Test
        public void contextLoads() {
        
            //方式1：@ConfigurationProperties
            System.out.println(person);
    
            //方式2：@Value
            System.out.println(person1);
            
        }
    
    }

---------------------------------------------------------------------------------------------------------------------------------------------------
    
注入值的方式2:  @Value

1.java

    Person1.java
    
    //@Component 为了使xx类加入spring的管理中
    
        @Component
        public class Person1 {
        
            @Value("${person1.last-name}")
            private String lastName;
            @Value("${person1.age}")
            private Integer age;
            @Value("${person1.yn}")
            private Boolean yn;
            @Value("${person1.birth}")
            private Date birth;
            
            private Map<String,Object> maps;
            private List<Object> lists;
            private Dog dog;
            
            //省略
        }
    
    Dog.java 
    
        Dog
        
        public class Dog {
        
            private String name;
            private Integer age;
            
            //省略
        }

2.application.yml或application.properties（两种注入方式与数据文件无关）

        person1.last-name=aa
        person1.age=20
        person1.yn=false
        person1.birth=2019/01/01
        person1.maps.k1=v1
        person1.maps.k2=aa
        person1.lists=a,1,2
        person1.dog.name=aa_dog
        person1.dog.age=3


3.测试类相同

        @RunWith(SpringRunner.class)
        @SpringBootTest
        public class SpringBoot02ConfigApplicationTests {
    
            @Autowired
            Person person;
        
            @Test
            public void contextLoads() {
            
                //方式1：@ConfigurationProperties
                System.out.println(person);
        
                //方式2：@Value
                System.out.println(person1);
                
            }
    
    }





#### @Value获取值和@ConfigurationProperties获取值比较

|                      | @ConfigurationProperties | @Value     |
| -------------------- | ------------------------ | ---------- |
| 功能                  | 批量注入配置文件中的属性    | 一个个指定 |
| 松散绑定（松散语法）    | 支持                     | 不支持     |    v
| SpEL                 | 不支持                    | 支持       |
| JSR303数据校验        | 支持                     | 不支持     |
| 复杂类型封装           | 支持                     | 不支持     |


配置文件yml还是properties他们都能获取到值；

如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；

如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties；


松散绑定:
=============================================================
@ConfigurationProperties(prefix = "person")
lastName last-name

    支持：
        ①、Person.java
        
            @Component
            @ConfigurationProperties(prefix = "person")
            public class Person {
            
                private String lastName;
            
            }
            
        @application.yml（或使用properties）
        
        lastName: person_zhangsan
        或
        last-name: person_zhangsan



@Value  

    不支持：

        ①、Person1.java：
        
            @Component
            public class Person1 {
                @Value("${person1.lastName}")
                private String lastName;
                
                //xxx
            }
        
        ②、application.yml（或使用properties）
        
            person1:
                lastName: person1_zhangsan
        
        测试报如下错误：
        
        Could not resolve placeholder 'person1.lastName' in value "${person1.lastName}"
=============================================================



SpEL：
=============================================================
@ConfigurationProperties(prefix = "person")

    不支持
    
        For input string: "${11*2}"
@Value

    支持
        
=============================================================




JSR303数据校验：
=============================================================

@ConfigurationProperties(prefix = "person")

    支持
    
        
@Value

    不支持


=============================================================



复杂类型封装
=============================================================

支持


不支持
=============================================================













