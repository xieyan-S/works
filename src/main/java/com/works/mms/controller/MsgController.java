package com.works.mms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.works.mms.entity.Message;
import com.works.mms.entity.User;
import com.works.mms.service.MsgService;
import com.works.mms.service.UserService;


@Controller
public class MsgController {
	
	@Autowired
	private HttpSession session;

	@Autowired
	private MsgService msgService;
	
	@Autowired
	private UserService userService;
	
	//消息管理
	@RequestMapping("/manage")
	public String manage(Model model) {
		User user = (User) session.getAttribute("user");
		List<Message> messageList = msgService.findByReceiver(user.getUsername());
		model.addAttribute("messageList", messageList);
		return "manage.html";//manage.html等于/manage
	}
	
	//删除消息
	@RequestMapping("/deleteMessage")
	public String deleteMessage(int id) {
		msgService.remove(id);
		return "redirect:/manage";
	}
	
	//消息已读
	@RequestMapping("/seenMessage")
	@ResponseBody
	public String seenMessage(int id) {
		Message message = msgService.findById(id);
		if(message!=null&&!message.isSeen()){
			boolean success = msgService.modifySeen(id);
			if(success){
				return "{\"message\":"+true+"}";
			}
		}
		return "{\"message\":"+false+"}";
	}
	
	//进入发送消息页面
	@RequestMapping("/send")
	public String send() {
		return "send.html";
	}
	
	//发送消息
	@RequestMapping("/sendMessage")
	public String sendMessage(Message message,Model model) {
		//System.out.println(message);
		User receiver = new User();
		receiver.setUsername(message.getReceiver());
		int receiverId = userService.findByUsername(receiver);
		if(receiverId!=0) {
			User user = (User) session.getAttribute("user");
			message.setSenderId(user.getId());
			message.setSender(user.getUsername());
			message.setReceiverId(receiverId);
			message.setDate(new Date());
			message.setSeen(false);
			System.out.println(message);
			boolean success = msgService.add(message);
			if(success)
			{
				return "send-success.html";
			}
			else
			{
				model.addAttribute("result", "发送失败");
			}
		}
		else
		{
			model.addAttribute("result", "该用户未注册");
		}
		model.addAttribute("message", message);
		return "send.html";
	}
	
	//回复消息
	@RequestMapping("/reply")
	public String reply(String receiver,Model model) {
		Message message = new Message();
		message.setReceiver(receiver);
		model.addAttribute("message", message);
		return "send.html";
	}
	
}
