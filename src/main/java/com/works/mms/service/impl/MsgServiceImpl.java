package com.works.mms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.works.mms.dao.MsgMapper;
import com.works.mms.entity.Message;
import com.works.mms.service.MsgService;

@Service
public class MsgServiceImpl implements MsgService {
	
	@Autowired
	private MsgMapper msgMapper;

	@Override
	public List<Message> findByReceiver(String receiver) {
		return msgMapper.selectByReceiver(receiver);
	}

	@Override
	public void remove(int id) {
		msgMapper.deleteById(id);
	}

	@Override
	public Message findById(int id) {
		return msgMapper.selectById(id);
	}

	@Override
	public boolean modifySeen(int id) {
		int rows = msgMapper.updateSeen(id);
		return rows > 0 ? true : false;
	}

	@Override
	public boolean add(Message message) {
		int rows = msgMapper.insert(message);
		return rows > 0 ? true : false;
	}

}
