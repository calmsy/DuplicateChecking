package com.Handler;

import com.beans.*;
import com.service.ClassScoreServiceImpl;
import com.service.ScoreServiceImpl;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/DuplicateChecking")
public class mainHandler{
    private ScoreServiceImpl scoreService;
    private ClassScoreServiceImpl classScoreService;

    public mainHandler() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        scoreService = (ScoreServiceImpl) ac.getBean("scoreService");
        classScoreService = (ClassScoreServiceImpl) ac.getBean("classScoreService");
    }

    @RequestMapping("/AllPerformance")
    public String AllPerformance(HttpServletRequest request){
        String url = "/display/AllPerformance.jsp";
        List<Classes> classes = classScoreService.findAllClass();
        List<CandCS> candCS = new ArrayList<CandCS>();
        for (Classes c : classes){
            CandCS candCS1 = new CandCS();
            candCS1.setaClass(c);
            ClassScore score = classScoreService.findClassScore(c.getClass_id());
            if(Double.isNaN(score.getAvg_final_score())){
                score.setAvg_final_score(0);
            }
            if(Double.isNaN(score.getAvg_total_score())){
                score.setAvg_total_score(0);
            }
            if(Double.isNaN(score.getAvg_usual_score())){
                score.setAvg_usual_score(0);
            }
            candCS1.setClassScore(score);
            candCS.add(candCS1);
        }
        request.getSession().setAttribute("candCS",candCS);
        return url;
    }
    @RequestMapping("/HomeworkDuplicateCheck")
    public String HomeworkDuplicateCheck(){
        String url = "/display/HomeworkDuplicateCheck.jsp";
        return url;
    }
    @RequestMapping("/SubmitAssignment")
    public String SubmitAssignment(){
        String url = "/display/SubmitAssignment.jsp";
        return url;
    }
    @RequestMapping("/upload")
    public String upload(){
        String url = "/display/success.jsp";

        return url;
    }
    @RequestMapping("/toViewStudents")
    public String toViewStudents(HttpServletRequest request){
        String url="/display/ViewStudents.jsp";
        List<SandSC> sandSCs = new ArrayList<SandSC>();
        String s =  request.getParameter("value");
        List<Student> students = scoreService.findStudentByClassName(s);
        List<Course> courses = scoreService.findAllCourse();
        for(Student student:students){
            SandSC sandSC = new SandSC();
            sandSC.setStudent(student);
            List<Score> scores = scoreService.findScore(student.getStudent_id());
            sandSC.setScores(scores);
            sandSCs.add(sandSC);
        }
        request.getSession().setAttribute("sandSCs",sandSCs);
        request.getSession().setAttribute("className",s);
        request.getSession().setAttribute("courses",courses);
        return url;
    }

    @RequestMapping("/toViewStudent")
    public String toViewStudent(HttpServletRequest request){
       String  url = "/display/ViewStudent.jsp";
       String id = request.getParameter("id");
       SandSC sandSC = new SandSC();
       sandSC.setStudent(scoreService.findStudentById(id));
       sandSC.setScores(scoreService.findScore(id));
       request.getSession().setAttribute("sandSC",sandSC);
       List<Course> courses = scoreService.findAllCourse();
       request.getSession().setAttribute("courses",courses);
       return url;
    }
    @RequestMapping("/toUpdateScore")
    public String toUpdateScore(HttpServletRequest request){
        String url="/display/UpdateScore.jsp";
        String student_id=request.getParameter("student");
        String course_id=request.getParameter("course");
        System.out.println(student_id+" "+course_id);
        Score score = scoreService.findScoreBySandC(student_id,course_id);
        Student student = scoreService.findStudentById(student_id);
        Course course = scoreService.findAllCourseById(course_id);

        request.getSession().setAttribute("score",score);
        request.getSession().setAttribute("student",student);
        request.getSession().setAttribute("course",course);

        return url;
    }
    @RequestMapping("/Update")
    public String Update(HttpServletRequest request){
        String url = "/display/ViewStudent.jsp";
        String student_id = request.getParameter("student");
        String course_id = request.getParameter("course");
        Double usual = Double.valueOf(request.getParameter("usual"));
        Double fina = Double.valueOf(request.getParameter("final"));
        Double total = Double.valueOf(request.getParameter("total"));
        Score score = new Score(student_id,course_id,usual,fina,total);
        Score score1 = scoreService.findScoreBySandC(student_id,course_id);
        if(score1==null){
            System.out.println(1);
            scoreService.addScore(score);
        }else{
            System.out.println(2);
            scoreService.modifyScore(score);
        }
        SandSC sandSC = new SandSC();
        sandSC.setStudent(scoreService.findStudentById(student_id));
        sandSC.setScores(scoreService.findScore(student_id));
        request.getSession().setAttribute("sandSC",sandSC);
        List<Course> courses = scoreService.findAllCourse();
        request.getSession().setAttribute("courses",courses);
        return url;
    }

}
