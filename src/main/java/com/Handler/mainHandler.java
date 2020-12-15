package com.Handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/DuplicateChecking")
public class mainHandler{

    @RequestMapping("/AllPerformance")
    public String AllPerformance(){
        String url = "/display/AllPerformance.jsp";

        return url;
    }
    @RequestMapping("/HomeworkCorrection")
    public String HomeworkCorrection(){
        String url = "/display/HomeworkCorrection.jsp";

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
}
