package com.kingduns.pertes.record;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kingduns.pertes.common.bean.Record;
import com.kingduns.pertes.config.bean.ReturnBean;
import com.kingduns.pertes.record.service.RecordService;

@RestController
@RequestMapping("rsat/record")
public class RecordController {
	
	@Autowired
	private RecordService recordService;
	
	@GetMapping("/getRecordList")
	public ReturnBean<?> getRecordList(){
		List<Record> records = recordService.queryRecordList();
		if(records != null && !records.isEmpty()) {
			return new ReturnBean<>(1, "查询成功！", records);
		}else {
			return new ReturnBean<>(0, "查询失败！", null);
		}
	}
}
