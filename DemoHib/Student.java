                                     // HIBERNATE
                              // Mapping relation;


                             // App.java
// package grv.demo;
// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
// import org.hibernate.cfg.Configuration;
// import org.hibernate.service.ServiceRegistry;
// public class App {
// public static void main(String[] args) {
// Laptop laptop = new Laptop();
// laptop.setLid(101);
// laptop.setLname("dell");
// Student s = new Student();
// s.setName("grvkmr");
// s.setRollno(3);
// s.setMarks(50);
// s.getLaptop().add(laptop);
// Configuration config = new
// Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.clas
// s);
// ServiceRegistry registry = new
// StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
// SessionFactory sf = config.buildSessionFactory(registry);
// Session session = sf.openSession();
// session.beginTransaction();
// session.save(laptop);
// session.save(s);
// session.getTransaction().commit();
// session.close();
// sf.close();
// }
// }




                                       // Laptop.java
// package grv.demo;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// //import jakarta.persistence.Entity;
// //import jakarta.persistence.Id;
// @Entity
// public class Laptop {
// @Id
// private int lid;
// private String lname;
// @ManyToOne
// private Student student;
// public Student getStudent() {
// return student;
// }
// public void setStudent(Student student) {
// this.student = student;
// }
// public int getLid() {
// return lid;
// }
// public void setLid(int lid) {
// this.lid = lid;
// }
// public String getLname() {
// return lname;
// }
// @Override
// public String toString() {
// return "Laptop [lid=" + lid + ", lname=" + lname + "]";
// }
// public void setLname(String lname) {
// this.lname = lname;
// }
// }










                                     // Student.java

// package grv.demo;
// import java.util.ArrayList;
// import java.util.List;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
// @Entity
// public class Student {
// @Id
// private int rollno;
// private String name;
// private int marks;
// @OneToMany(mappedBy="student")
// private List<Laptop> laptop = new ArrayList<>();
// public int getRollno() {
// return rollno;
// }
// public void setRollno(int rollno) {
// this.rollno = rollno;
// }
// public String getName() {
// return name;
// }
// public void setName(String name) {
// this.name = name;
// }
// public int getMarks() {
// return marks;
// }
// public void setMarks(int marks) {
// this.marks = marks;
// }
// public List<Laptop> getLaptop() {
// return laptop;
// }
// public void setLaptop(List<Laptop> laptop) {
// this.laptop = laptop;
// }
// @Override
// public String toString() {
// return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + ", laptop=" +
// laptop + "]";
// }
// }


   


                // Hibernate.cfg.xml
// <?xml version="1.0" encoding="UTF-8"?>
// <!DOCTYPE hibernate-configuration PUBLIC
// "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
// "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
// <hibernate-configuration>
// <session-factory>
// <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
// <property name="hibernate.connection.password">Grv788943%</property>
// <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/neon</property>
// <property name="hibernate.connection.username">root</property>
// <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
// <property name="hibernate.hbm2ddl.auto">update</property>
// <property name="show_sql">true</property>
// </session-factory>
// </hibernate-configuration>



             // Pom.xml
// <project xmlns="http://maven.apache.org/POM/4.0.0"
// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
// xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
// http://maven.apache.org/xsd/maven-4.0.0.xsd">
// <modelVersion>4.0.0</modelVersion>
// <groupId>grv</groupId>
// <artifactId>demo</artifactId>
// <version>0.0.1-SNAPSHOT</version>
// <packaging>jar</packaging>
// <name>demo</name>
// <url>http://maven.apache.org</url>
// <properties>
// <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
// </properties>
// <dependencies>
// <dependency>
// <groupId>org.hibernate.orm</groupId>
// <artifactId>hibernate-core</artifactId>
// <version>6.5.0.Final</version>
// </dependency>
// <dependency>
// <groupId>javax.persistence</groupId>
// <artifactId>javax.persistence-api</artifactId>
// <version>2.2</version>
// </dependency>
// <dependency>
// <groupId>com.mysql</groupId>
// <artifactId>mysql-connector-j</artifactId>
// <version>8.4.0</version>
// </dependency>
// <dependency>
// <groupId>junit</groupId>
// <artifactId>junit</artifactId>
// <version>3.8.1</version>
// <scope>test</scope>
// </dependency>
// </dependencies>
// </project>








--------------------------------------------------------------------------------------------------------


//                             Hibernate caching
//              First level caching(default):-
//          App.java
// package grv.demo;
// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
// import org.hibernate.cfg.Configuration;
// import org.hibernate.service.ServiceRegistry;
// public class App {
//  public static void main(String[] args) {


//  Alien a= null;
//  Configuration config = new
// Configuration().configure().addAnnotatedClass(Alien.class);

//  ServiceRegistry registry = new
// StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//  SessionFactory sf = config.buildSessionFactory(registry);
//  Session session1 = sf.openSession();

//  session1.beginTransaction();
//  a = (Alien)session1.get(Alien.class, 101);
//  System.out.println(a);
//  session1.getTransaction().commit();

//  session1.close();


//  Session session2 = sf.openSession();
//  a = (Alien)session2.get(Alien.class, 101);
//  System.out.println(a);
// session2.getTransaction().commit();

//  session2.close();



//  sf.close();
//  }
// }










// Alien.java:
// package grv.demo;
// import javax.persistence.Cacheable;
// import org.hibernate.annotations.Cache;
// import org.hibernate.annotations.CacheConcurrencyStrategy;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// @Entity
// @Table(name="Alien_Table")
// @Cacheable
// @Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
// public class Alien {
// @Id
// private int aid;
// private String acolor;
//  private String aname;
// public int getAid() {
// return aid;
// }
// public void setAid(int aid) {
// this.aid = aid;
// }
// public String getAcolor() {
// return acolor;
// }
// public void setAcolor(String acolor) {
// this.acolor = acolor;
// }
// public String getAname() {
// return aname;
// }
// @Override
// public String toString() {
// return "Alien [aid=" + aid + ", acolor=" + acolor + ", aname=" + aname +
// "]";
// }
// public void setAname(String aname) {
// this.aname = aname;
// }

// }











// Cfg.xml
// <?xml version="1.0" encoding="UTF-8"?>
// <!DOCTYPE hibernate-configuration PUBLIC
// "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
// "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
// <hibernate-configuration>
// <session-factory>
// <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
// <property name="hibernate.connection.password">Grv788943%</property>
// <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/neon</property>
// <property name="hibernate.connection.username">root</property>
// <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
// <property name="hibernate.hbm2ddl.auto">update</property>
// <property name="hibernate.show_sql">true</property>
// </session-factory>
// </hibernate-configuration>
// Pom.xml
// <project xmlns="http://maven.apache.org/POM/4.0.0"
// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
// xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
// http://maven.apache.org/xsd/maven-4.0.0.xsd">
// <modelVersion>4.0.0</modelVersion>
// <groupId>grv</groupId>
// <artifactId>demo</artifactId>
// <version>0.0.1-SNAPSHOT</version>
// <packaging>jar</packaging>
// <name>demo</name>
// <url>http://maven.apache.org</url>
// <properties>
// <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
// </properties>
// <dependencies>
// <dependency>
// <groupId>org.hibernate.orm</groupId>
// <artifactId>hibernate-core</artifactId>
// <version>6.5.0.Final</version>
// </dependency>
// <dependency>
// <groupId>javax.persistence</groupId>
// <artifactId>javax.persistence-api</artifactId>
// <version>2.2</version>
// </dependency>
// <!-- https://mvnrepository.com/artifact/net.sf.ehcache/ehcache -->
// <dependency>
// <groupId>com.mysql</groupId>
// <artifactId>mysql-connector-j</artifactId>
// <version>8.4.0</version>
// </dependency>
// <dependency>
// <groupId>junit</groupId>
// <artifactId>junit</artifactId>
// <version>3.8.1</version>
// <scope>test</scope>
// </dependency>
// </dependencies>
// </project>











// Second level caching:
//  App.java
// --------------------------------------------------------------------------------
// package com.telusko.DemoHib;
// import java.util.Collection;
// import org.hibernate.Session;
// import org.hibernate.Transaction;
// import org.hibernate.SessionFactory;
// import org.hibernate.cfg.Configuration;
// import org.hibernate.service.ServiceRegistry;
// import org.hibernate.service.ServiceRegistryBuilder;
// public class App
// {
//  public static void main( String[] args )
//  {
//  Alien a = null;

//  Configuration con = new
// Configuration().configure().addAnnotatedClass(Alien.class);
//  ServiceRegistry reg = new
// ServiceRegistryBuilder().applySettings(con.getProperties()).buildSe
// rviceRegistry();
//  SessionFactory sf = con.buildSessionFactory(reg);
//  Session session1 = sf.openSession();
//  session1.beginTransaction();


//  a = (Alien) session1.get(Alien.class, 101);
//  System.out.println(a);


//  session1.getTransaction().commit();
//  session1.close();

//  Session session2 = sf.openSession();
//  session2.beginTransaction();

//  a = (Alien) session2.get(Alien.class, 101);
//  System.out.println(a);

//  session2.getTransaction().commit();
//  session2.close();

//  }
// }
// --------------------------------------------------------------------------------
// Alien.java
// --------------------------------------------------------------------------------
// package com.telusko.DemoHib;
// import java.util.ArrayList;
// import java.util.Collection;
// import javax.persistence.Cacheable;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.Id;
// import javax.persistence.OneToMany;
// import javax.persistence.Table;
// import javax.persistence.Transient;
// import org.hibernate.annotations.Cache;
// import org.hibernate.annotations.CacheConcurrencyStrategy;
// @Entity
// @Table(name="alien_table")
// @Cacheable
// @Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
// public class Alien
// {
// @Id
// private int aid;
// private String aname;
// private String color;
// public int getAid() {
// return aid;
// }
// public void setAid(int aid) {
// this.aid = aid;
// }
// public String getAname() {
// return aname;
// }
// public void setAname(String aname) {
// this.aname = aname;
// }
// public String getColor() {
// return color;
// }
// public void setColor(String color) {
// this.color = color;
// }
// @Override
// public String toString() {
// return "Alien [aid=" + aid + ", aname=" + aname + ",
// color=" + color + "]";
// }
// }
// --------------------------------------------------------------------------------
//  hibernate.cfg.xml
// --------------------------------------------------------------------------------
// <?xml version="1.0" encoding="UTF-8"?>
// <!DOCTYPE hibernate-configuration PUBLIC
// "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
// "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
// <hibernate-configuration>
//  <session-factory>
//  <property
// name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</
// property>
//  <property
// name="hibernate.connection.password">1234</property>
//  <property
// name="hibernate.connection.url">jdbc:mysql://localhost:3306/neon
// </property>
//  <property
// name="hibernate.connection.username">root</property>
//  <property
// name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</pro
// perty>
//  <property name="hbm2ddl.auto">update</property>
//  <property name="show_sql">true</property>

//  <property
// name="hibernate.cache.use_second_level_cache">true</property>

//  <property
// name="hibernate.cache.region.factory_class">org.hibernate.cache.
// ehcache.EhCacheRegionFactory</property>
//  </session-factory>
// </hibernate-configuration>
// --------------------------------------------------------------------------------
//  pom.xml
// --------------------------------------------------------------------------------
// <project xmlns="http://maven.apache.org/POM/4.0.0"
// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
// http://maven.apache.org/xsd/maven-4.0.0.xsd">
//  <modelVersion>4.0.0</modelVersion>
//  <groupId>com.telusko</groupId>
//  <artifactId>DemoHib</artifactId>
//  <version>0.0.1-SNAPSHOT</version>
//  <packaging>jar</packaging>
//  <name>DemoHib</name>
//  <url>http://maven.apache.org</url>
//  <properties>

// <project.build.sourceEncoding>UTF-8</project.build.sourceEncodin
// g>
//  </properties>
//  <dependencies>
//  <dependency>
//  <groupId>junit</groupId>
//  <artifactId>junit</artifactId>
//  <version>3.8.1</version>
//  <scope>test</scope>
//  </dependency>

//  <!--
// https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
// <dependency>
//  <groupId>org.hibernate</groupId>
//  <artifactId>hibernate-core</artifactId>
//  <version>4.1.6.Final</version>
// </dependency>
// <dependency>
//  <groupId>net.sf.ehcache</groupId>
//  <artifactId>ehcache</artifactId>
//  <version>2.10.3</version>
// </dependency>
// <dependency>
//  <groupId>org.hibernate</groupId>
//  <artifactId>hibernate-ehcache</artifactId>
//  <version>4.1.6.Final</version>
// </dependency>
// <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java
// -->
// <dependency>
//  <groupId>mysql</groupId>
//  <artifactId>mysql-connector-java</artifactId>
//  <version>5.1.47</version>
// </dependency>

//  </dependencies>
// </project>





----------------------------------------------------------------------------------------------------------------



// HQL
// App.java
// package grv.demo;
// import java.util.List;
// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
// import org.hibernate.cfg.Configuration;
// import org.hibernate.query.Query;
// import org.hibernate.service.ServiceRegistry;
// public class App {
// public static void main(String[] args) {
// Configuration con =new Configuration().configure().addAnnotatedClass(Student.class);
// ServiceRegistry registry = new
// StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
// SessionFactory sf = con.buildSessionFactory(registry);
// Session session = sf.openSession();
// session.beginTransaction();
// // Query<Student> q = session.createQuery("from Student where rollno =7", Student.class);
// // Student s= (Student)q.uniqueResult();
// // System.out.println(s);
// // List<Student> l= q.list();
// // for(Student s :l) {
// // System.out.println(s);
// // }/
// //
// // Query<Object[]> query = session.createQuery("select s.rollno, s.name, s.marks from Student
// s", Object[].class);
// // List<Object[]> results = query.list();
// //
// //
// // for (Object[] row : results) {
// // Integer rollno = (Integer) row[0];
// // String name = (String) row[1];
// // Integer marks = (Integer) row[2];
// // System.out.println("Rollno: " + rollno + ", Name: " + name + ", Marks: " + marks);
// // }
// SQLQuery q = session.createSQLQuery();
// session.getTransaction().commit();
// session.close();
// sf.close();
// }
// }
// Student.java
// package grv.demo;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// @Entity
// public class Student {
// @Id
// private int rollno;
// private String name;
// private int marks;
// @Override
// public String toString() {
// return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
// }
// public int getRollno() {
// return rollno;
// }
// public void setRollno(int rollno) {
// this.rollno = rollno;
// }
// public String getName() {
// return name;
// }
// public void setName(String name) {
// this.name = name;
// }
// public int getMarks() {
// return marks;
// }
// public void setMarks(int marks) {
// this.marks = marks;
// }
// }
// Cfg
// <?xml version="1.0" encoding="UTF-8"?>
// <!DOCTYPE hibernate-configuration PUBLIC
// "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
// "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
// <hibernate-configuration>
// <session-factory>
// <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
// <property name="hibernate.connection.password">Grv788943%</property>
// <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/neon</property>
// <property name="hibernate.connection.username">root</property>
// <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
// <property name="hibernate.hbm2ddl.auto">update</property>
// <property name="hibernate.show_sql">true</property>
// </session-factory>
// </hibernate-configuration>
// Pom.xml
// <project xmlns="http://maven.apache.org/POM/4.0.0"
// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
// xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
// http://maven.apache.org/xsd/maven-4.0.0.xsd">
// <modelVersion>4.0.0</modelVersion>
// <groupId>grv</groupId>
// <artifactId>demo</artifactId>
// <version>0.0.1-SNAPSHOT</version>
// <packaging>jar</packaging>
// <name>demo</name>
// <url>http://maven.apache.org</url>
// <properties>
// <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
// </properties>
// <dependencies>
// <dependency>
// <groupId>org.hibernate.orm</groupId>
// <artifactId>hibernate-core</artifactId>
// <version>6.5.0.Final</version>
// </dependency>
// <dependency>
// <groupId>javax.persistence</groupId>
// <artifactId>javax.persistence-api</artifactId>
// <version>2.2</version>
// </dependency>
// <!-- https://mvnrepository.com/artifact/net.sf.ehcache/ehcache -->
// <dependency>
// <groupId>com.mysql</groupId>
// <artifactId>mysql-connector-j</artifactId>
// <version>8.4.0</version>
// </dependency>
// <dependency>
// <groupId>junit</groupId>
// <artifactId>junit</artifactId>
// <version>3.8.1</version>
// <scope>test</scope>
// </dependency>
// </dependencies>
// </project>