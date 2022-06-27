package nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")//给这个类取一个访问名
public class AlpahController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){

        return "Hello spring boot";
    }
//post请求
@RequestMapping(path ="/student",method = RequestMethod.POST)
@ResponseBody
public String savestudent(String name,int age){
    System.out.println(name);
    System.out.println(age);
    return "success";
}
//响应html数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getteacher(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age","30");
        mav.setViewName("/demo/view");
        return mav;
    }
    //第二种响应方法
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getschool(Model model){
        model.addAttribute("name","南昌航空大学");
        model.addAttribute("age","70");
        return "/demo/view";

    }
    //响应JSON数据（异步请求）
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getemp(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","小明");
        map.put("age","25");
        map.put("salary","8000.00");
        return map;
        }
    }
