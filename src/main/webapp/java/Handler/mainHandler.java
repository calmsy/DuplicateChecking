package Handler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/DuplicateChecking")
public class mainHandler{

    @RequestMapping("/AllPerformance")
    public String AllPerformance(){
        String url = "/display/maindisplay/AllPerformance";

        return url;
    }
    @RequestMapping("/HomeworkCorrection")
    public String HomeworkCorrection(){
        String url = "/display/maindisplay/HomeworkCorrection";

        return url;
    }
    @RequestMapping("/HomeworkDuplicateCheck")
    public String HomeworkDuplicateCheck(){
        String url = "/display/maindisplay/HomeworkDuplicateCheck";

        return url;
    }
    @RequestMapping("/SubmitAssignment")
    public String SubmitAssignment(){
        String url = "/display/maindisplay/SubmitAssignment";

        return url;
    }
}
