package com.kingduns.pertes.iteration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingduns.pertes.common.bean.Iteration;
import com.kingduns.pertes.config.bean.ReturnBean;
import com.kingduns.pertes.iteration.service.IterationService;

@RestController
@RequestMapping("rsat/iteration")
public class IterationController {
	
	@Autowired
	private IterationService iterationService;
	
	@GetMapping("getIterationList")
	public ReturnBean<List<Iteration>> getIterationList(){
		return new ReturnBean<List<Iteration>>(ReturnBean.SUCCESS, "查询成功！", iterationService.getIterationList());
	}
}
