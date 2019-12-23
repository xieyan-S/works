package com.works.mms.service;

import java.util.List;

import com.works.mms.entity.Message;

public interface MsgService {

	List<Message> findByReceiver(String receiver);

	void remove(int id);

	Message findById(int id);

	boolean modifySeen(int id);

	boolean add(Message message);
	
	
	
}
