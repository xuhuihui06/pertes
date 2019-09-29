package com.kingduns.pertes.iteration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingduns.pertes.common.bean.Iteration;
import com.kingduns.pertes.common.mapper.IterationMapper;
import com.kingduns.pertes.iteration.service.IterationService;

@Service
public class IterationServiceImpl implements IterationService {

	@Autowired
	private IterationMapper iterationMapper;
	
	@Override
	public List<Iteration> getIterationList() {
		return iterationMapper.queryIterationList();
	}

}
