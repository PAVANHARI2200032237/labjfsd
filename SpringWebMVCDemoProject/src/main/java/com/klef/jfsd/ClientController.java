package com.klef.jfsd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController 
{
	@RequestMapping(path = "/",method = RequestMethod.GET)
	public ModelAndView demo() 
	{
		ModelAndView mv  = new ModelAndView();
		mv.setViewName("demo"); //demo is view name or jsp file name
		return mv;		
		}
	@GetMapping(path="/demo1") //instead of RequestMapping
	public ModelAndView demo1()
	{
		ModelAndView mv = new ModelAndView("demo1");
		return mv;
	}
	@GetMapping("/demo2")
	public ModelAndView demo2()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("demo2");
		return mv;
	}
	@GetMapping("/demo3")
	@ResponseBody  // used to print message directly on browser or return
	public String demo3()
	{
		return "JFSD S31";
	}
	@GetMapping("add")
	@ResponseBody
	public String add(@RequestParam("a") int x,@RequestParam("b") int y)
	{
		int z = x+y;
		return Integer.toString(z);
	}
	@GetMapping("displayname")
	@ResponseBody
	public String displayname(@RequestParam("fname") String f, @RequestParam("lname") String l)
	{
		return f+" "+l;
	}
	@GetMapping("displayid")
	@ResponseBody
	public String displayid(@RequestParam("id")  long eid)
	{
		return "ID : " + Long.toString(eid);
	}
	@GetMapping("viewname/{fname}/{lname}")
	@ResponseBody
	public String viewname(@PathVariable("fname")  String a,@PathVariable("lname")  String b)
	{
		return a+" "+b;
	}
	@GetMapping("viewid/{id}")
	@ResponseBody
	public String viewid(@PathVariable("id")  int sid)
	{
		return Integer.toString(sid);
	}
	@GetMapping("mul/{a}/{b}")
	@ResponseBody
	public String mul(@PathVariable("a")  int x,@PathVariable("b") int y)
	{
		return Integer.toString(x*y);
	}
	@GetMapping("display")
	public ModelAndView display()
	{
		ModelAndView mv = new ModelAndView("display");
		mv.addObject("name","VENKAT");
		return mv;
	}
	@GetMapping("sub")
	public ModelAndView output(@RequestParam("a") int x,@RequestParam("b") int y)
	{
		int output = x - y;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("output");
		mv.addObject("result",output);
		return mv;
	}
	@GetMapping("show/{fname}/{lname}")
	public ModelAndView show(@PathVariable("fname") String x,@PathVariable("lname") String y)
	{
		ModelAndView mv = new ModelAndView("show");
		String name = x +" "+ y;
		mv.addObject("fname", x.toUpperCase());
		mv.addObject("lname", y.toUpperCase());
		mv.addObject("name", name.toUpperCase());
		return mv;
	}
}
