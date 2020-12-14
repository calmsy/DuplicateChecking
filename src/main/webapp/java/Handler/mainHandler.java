package Handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/DuplicateChecking")
public class mainHandler{
    @RequestMapping("/ff")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/welcome.jsp");
        return mv;
    }

    @RequestMapping("/AllPerformance")
    public String AllPerformance(){
        String url = "/display/maindisplay/AllPerformance.jsp";

        return url;
    }
    @RequestMapping("/HomeworkCorrection")
    public String HomeworkCorrection(){
        String url = "/display/maindisplay/HomeworkCorrection.jsp";

        return url;
    }
    @RequestMapping("/HomeworkDuplicateCheck")
    public String HomeworkDuplicateCheck(){
        String url = "/display/maindisplay/HomeworkDuplicateCheck.jsp";

        return url;
    }
    @RequestMapping("/SubmitAssignment")
    public String SubmitAssignment(){
        String url = "/display/maindisplay/SubmitAssignment.jsp";

        return url;
    }
}
