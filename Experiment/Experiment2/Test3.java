package Experiment.Experiment2;

// 编写一个一个简单的学生成绩管理程序，该程序中有三个类：学生(Student)、课程(Course)和成绩(Grade)，学生类的属性主要有姓
// 名、学号、性别和班级，课程类属性主要有课程号、课程名和学分，成绩类的主要属性有学生姓名、课程名和课程成绩。要求：

import java.util.*;

//        学生、课程和成绩信息分别存储在一个List容器中。
//        程序的主要能包括：计算每个学生的总成绩、平均成绩和总学分，计算每个班级的平均成绩，按照学生平均成绩由
//        高到低的顺序进行排序，统计所有学生每门课程的平均成绩。
//        设计一个数据集来测试上述功能的正确性。
public class Test3 {

  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("张三", "1", true, "1"));
    studentList.add(new Student("李四", "2", false, "2"));
    studentList.add(new Student("王五", "3", true, "3"));

    List<Course> courseList = new ArrayList<>();
    courseList.add(new Course("1", "Java", 2));
    courseList.add(new Course("2", "C++", 1));
    courseList.add(new Course("3", "Python", 3));

    List<Grade> gradeList = new ArrayList<>();
    gradeList.add(new Grade("张三", "Java", 92));
    gradeList.add(new Grade("李四", "Java", 90));
    gradeList.add(new Grade("王五", "Java", 100));

    gradeList.add(new Grade("张三", "C++", 92));
    gradeList.add(new Grade("李四", "C++", 94));
    gradeList.add(new Grade("王五", "C++", 90));

    gradeList.add(new Grade("张三", "Python", 82));
    gradeList.add(new Grade("李四", "Python", 88));
    gradeList.add(new Grade("王五", "Python", 70));

    Map<String, X> NameOfScore = new HashMap<>();
    Map<String, Integer> CourseScore = new HashMap<>();
    Map<String, X> classScore = new HashMap<>();
    for (Course course : courseList) {
      CourseScore.put(course.getName(), course.getScore());
    }
    for (Student student : studentList) {
      //        assert false;
      NameOfScore.put(student.getName(), new X(0.0, 0, 0));
    }

    for (Student student : studentList) {
      for (Grade grade : gradeList) {
        if (Objects.equals(student.getName(), grade.getStudentName())) {
          //          assert NameOfScore != null;
          double score = NameOfScore.get(student.getName()).getScore();
          int num = NameOfScore.get(student.getName()).getNum() + 1;
          int SCORE =
              CourseScore.get(grade.getCourseName())
                  + NameOfScore.get(student.getName()).getStudyScore();

          NameOfScore.put(student.getName(), new X(score + grade.getCourseScore(), num, SCORE));
        }
      }
      if (classScore.get(student.getInClass()) == null) {
        classScore.put(
            student.getInClass(), new X(NameOfScore.get(student.getName()).getScore(), 1));
      } else {
        classScore.put(
            student.getInClass(),
            new X(
                (NameOfScore.get(student.getName()).getScore()
                    + classScore.get(student.getInClass()).getScore()),
                classScore.get(student.getInClass()).getNum() + 1));
      }
    }
    //    List<String,Double> list = new ArrayList<>();
    List<NameScore> nameScoreList = new ArrayList<>();
    for (String key : NameOfScore.keySet()) {
      System.out.println(
          "学生"
              + key
              + "的总成绩为："
              + NameOfScore.get(key).getScore()
              + ",平均成绩为："
              + NameOfScore.get(key).getScore() / NameOfScore.get(key).getNum()
              + ",总学分为："
              + NameOfScore.get(key).getStudyScore());
      nameScoreList.add(new NameScore(key, NameOfScore.get(key).getScore()));
    }
    for (String key : classScore.keySet()) {
      System.out.println(
          "班级" + key + "的平均成绩为：" + classScore.get(key).getScore() / classScore.get(key).getNum());
    }
    System.out.println("按照学生成绩降序：");
    Collections.sort(nameScoreList);
    for (NameScore nameScore : nameScoreList) {
      System.out.println(nameScore.getName() + " " + nameScore.getScore());
    }
    Map<String, X> gradeMap = new HashMap<>();
    for (Grade grade : gradeList) {
      if (gradeMap.get(grade.getCourseName()) == null)
        gradeMap.put(grade.getCourseName(), new X(grade.getCourseScore(), 1));
      else {
        gradeMap.put(
            grade.getCourseName(),
            new X(
                grade.getCourseScore() + gradeMap.get(grade.getCourseName()).getScore(),
                gradeMap.get(grade.getCourseName()).getNum() + 1));
      }
    }
    for (String key : gradeMap.keySet()) {
      System.out.println(
          "课程：" + key + "的平均成绩：" + gradeMap.get(key).getScore() / gradeMap.get(key).getNum());
    }
  }
}

class NameScore implements Comparable<NameScore> {
  String name;
  double score;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public NameScore(String name, double score) {
    this.name = name;
    this.score = score;
  }

  @Override
  public int compareTo(NameScore o) {
    return (-1) * (int) (this.score - o.getScore());
  }
}

class X {
  double score;
  int num;

  int studyScore;

  public X(double score, int num, int studyScore) {
    this.score = score;
    this.num = num;
    this.studyScore = studyScore;
  }

  public int getStudyScore() {
    return studyScore;
  }

  public void setStudyScore(int studyScore) {
    this.studyScore = studyScore;
  }

  public X(double score, int num) {
    this.score = score;
    this.num = num;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }
}

class Grade {
  String studentName;
  String courseName;
  double courseScore;

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public double getCourseScore() {
    return courseScore;
  }

  public void setCourseScore(double courseScore) {
    this.courseScore = courseScore;
  }

  public Grade(String studentName, String courseName, double courseScore) {
    this.studentName = studentName;
    this.courseName = courseName;
    this.courseScore = courseScore;
  }
}

class Course {
  String ID;

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  String name;
  int score;

  public Course(String ID, String name, int score) {
    this.ID = ID;
    this.name = name;
    this.score = score;
  }
}

class Student {
  String name;
  String ID;
  boolean sex;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public boolean isSex() {
    return sex;
  }

  public void setSex(boolean sex) {
    this.sex = sex;
  }

  public String getInClass() {
    return inClass;
  }

  public void setInClass(String inClass) {
    this.inClass = inClass;
  }

  String inClass;

  public Student(String name, String ID, boolean sex, String inClass) {
    this.name = name;
    this.ID = ID;
    this.sex = sex;
    this.inClass = inClass;
  }
}
