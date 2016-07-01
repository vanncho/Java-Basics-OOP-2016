package com.company.models;

import com.company.exceptions.DuplicateEntryInStructureException;
import com.company.exceptions.InvalidStringException;
import com.company.exceptions.KeyNotFoundException;
import com.company.io.OutputWriter;
import com.company.staticData.ExceptionMessages;

import java.util.*;

public class Student {
    private String userName;
    private HashMap<String, Course> enrolledCourses;
    private HashMap<String, Double> marksByCourseName;

    public Student(String userName) {
        this.setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public String getUserName() {
        return userName;
    }

    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(marksByCourseName);
    }

    public void setUserName(String userName) {

        if (userName == null || userName.equals("")){
            throw new InvalidStringException();
        }

        this.userName = userName;
    }

    public void enrollInCourse(Course course){
        if (this.enrolledCourses.containsKey(course.getName())){
            throw new DuplicateEntryInStructureException(this.userName, course.getName());
        }

        this.enrolledCourses.put(course.getName(), course);
    }

    public void setMarksInCourse(String courseName, int ... scores){
        if (!this.enrolledCourses.containsKey(courseName)){
            throw new KeyNotFoundException();
        }
        if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
        }

        double mark = this.calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }

    private double calculateMark(int[] scores) {
        double percentageOfSolvedExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);

        double mark = percentageOfSolvedExam * 4 + 2;
        return mark;
    }
}
