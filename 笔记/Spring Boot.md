
------------------------------------------------------------------------------------------------------------------------------
新建项目：

1.
    file ---> project ---> Spring Initializr

2.
    选择jdk、package、合适的依赖、项目路径


coding:

注入值的方式1:

1.Person.java、Dog.java

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
    
2.application.yml
        
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
            System.out.println("\n");
            System.out.println(person);
            System.out.println("\n");
        }
    
    }

---------------------------------------------------------------------------------------------------------------------------------------------------
    
注入值的方式2:

1.java

    Person.java
    
        @Component
        public class Person {
        
            @Value("${person.last-name}")
            private String lastName;
            @Value("${person.age}")
            private Integer age;
            @Value("${person.yn}")
            private Boolean yn;
            @Value("${person.birth}")
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

2.application.properties

        person.last-name=aa
        person.age=20
        person.yn=false
        person.birth=2019/01/01
        person.maps.k1=v1
        person.maps.k2=aa
        person.lists=a,1,2
        person.dog.name=aa_dog
        person.dog.age=3


3.测试类相同








































