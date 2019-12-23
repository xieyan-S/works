package com.works.mms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.works.mms.entity.Message;

@Mapper
public interface MsgMapper {

	@Select("select * from message where receiver = #{receiver}")
	List<Message> selectByReceiver(String receiver);

	@Delete("delete from message where id = #{id}")
	void deleteById(int id);

	@Select("select * from message where id = #{id}")
	Message selectById(int id);

	@Update("update message set seen = 1 where id = #{id}")
	int updateSeen(int id);

	@Insert("insert into message(title,senderId,sender,receiverId,receiver,content,date,seen) values(#{title},#{senderId},#{sender},#{receiverId},#{receiver},#{content},#{date},#{seen})")
	int insert(Message message);
	
	
	
}
