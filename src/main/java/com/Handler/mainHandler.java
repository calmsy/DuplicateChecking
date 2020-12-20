package com.Handler;

import com.beans.*;
import com.service.ClassScoreServiceImpl;
import com.service.ScoreServiceImpl;
import com.utils.DupCheckMain;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/DuplicateChecking")
public class mainHandler{
    private ScoreServiceImpl scoreService;
    private ClassScoreServiceImpl classScoreService;
    String path = "/WEB-INF/upload";

    public mainHandler() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        scoreService = (ScoreServiceImpl) ac.getBean("scoreService");
        classScoreService = (ClassScoreServiceImpl) ac.getBean("classScoreService");
    }
    //登录
        @RequestMapping("/signIn")
        public String doFirst(String name,String password) {
        if ("ding".equals(name) && "123".equals(password)) {
           return "redirect:/index.jsp";
       }
        else
            return "/WEB-INF/error.jsp";
    }


    @RequestMapping("/AllPerformance")
    public String AllPerformance(HttpServletRequest request){
        //System.out.println("0000000000000000000");
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
            DecimalFormat df   = new DecimalFormat("######0.0");
            score.setAvg_final_score(Double.parseDouble(df.format(score.getAvg_final_score())));
            score.setAvg_total_score(Double.parseDouble(df.format(score.getAvg_total_score())));
            score.setAvg_usual_score(Double.parseDouble(df.format(score.getAvg_usual_score())));
            candCS1.setClassScore(score);
            candCS.add(candCS1);
        }
        request.getSession().setAttribute("candCS",candCS);
        return url;
    }
    @RequestMapping("/HomeworkDuplicateCheck")
    public String HomeworkDuplicateCheck(HttpServletRequest request){
        String savePath = request.getServletContext().getRealPath(path);
        File folder = new File(savePath);
        File[] f = folder.listFiles();
        List<File> files = new ArrayList<File>();
        if(f != null){
            for(int i=0; i<f.length; i++){
                if(f[i].isFile()){
                    files.add(f[i]);
                }
            }
        }
        request.getSession().setAttribute("files",files);
        String url = "/display/HomeworkDuplicateCheck.jsp";
        return url;
    }
    @RequestMapping("/SubmitAssignment")
    public String SubmitAssignment(){
        String url = "/display/SubmitAssignment.jsp";
        return url;
    }
    @RequestMapping("/Upload")
    public void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = request.getServletContext().getRealPath(path);
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
        //消息提示
        String message = "";
        try{
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if(!ServletFileUpload.isMultipartContent(request)){
                //按照传统方式获取数据
                return;
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    System.out.println(name + "=" + value);
                }else{//如果fileitem中封装的是上传文件
                    //得到上传的文件名称，
                    String filename = item.getName();
                    System.out.println(filename);
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while((len=in.read(buffer))>0){
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    message = "文件上传成功！";
                }
            }
        }catch (Exception e) {
            message= "文件上传失败！";
            e.printStackTrace();
        }
        request.setAttribute("message",message);
        request.getRequestDispatcher("/upload/message.jsp").forward(request, response);
    }
    @RequestMapping("/toDuplicateCheck")
    public String toDuplicateCheck(HttpServletRequest request){
        String savePath = request.getServletContext().getRealPath(path);
        String fileName = request.getParameter("fileName");
        String filePath = savePath + "/" + fileName;

        DupCheckMain dupCheck = new DupCheckMain();
        File folder = new File(savePath);
        File[] f = folder.listFiles();
        List<MyFile> myFiles = new ArrayList<MyFile>();
        if(f != null){
            for(int i=0; i<f.length; i++){
                if(!fileName.equals(f[i].getName())){
                    double similarity = dupCheck.getRepetiveRate(filePath, f[i].getAbsolutePath());
                    if(similarity > 0.3){
                        myFiles.add(new MyFile(f[i].getName(), String.format("%.2f",similarity)));
                    }
                }
            }
        }
        Integer flag = 1;
        if(myFiles.size() == 0){
            flag = 0;
        }
        request.getSession().setAttribute("flag",flag);
        request.getSession().setAttribute("myFiles",myFiles);
        return "/display/ShowSimilarity.jsp";
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
