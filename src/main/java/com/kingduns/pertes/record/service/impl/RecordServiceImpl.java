package com.kingduns.pertes.record.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingduns.pertes.common.bean.Record;
import com.kingduns.pertes.common.mapper.RecordMapper;
import com.kingduns.pertes.record.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordMapper recordMapper;

	@Override
	public List<Record> queryRecordList() {
		return recordMapper.queryRecordList();
	}
}
