package com.anbao.service;

import java.util.List;

import com.anbao.dao.AreaMapper;
import com.anbao.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anbao.dao.UserMapper;
import com.anbao.pojo.UserExample.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AreaMapper areaMapper;

	public User getUserByTel(String tel) {
		//����������ѯ����
		UserExample example = new UserExample();
		//���ò�ѯ����
		example.createCriteria().andTelEqualTo(tel);
		List<User> userList = userMapper.selectByExample(example);
		if(userList!=null && userList.size()>=1){
			User user = userList.get(0);
			if(user.getAid()!=null){
				Area area = areaMapper.selectByPrimaryKey(user.getAid());
				user.setAddr(area.getAddr());
			}
			return user;
		}else return null;
	}

	//ע���û�
	public String updataUser(User user) {
		//2��ʾ����Ա
		userMapper.updateByPrimaryKeySelective(user);
		return "ok";
	}

	//��ѯ���б�����state=2,page=��ǰҳ��limitÿҳ��ʾ����
	public DataResult selectAllUser(Integer page, Integer limit,Integer aid,String equName) {
		//���÷�ҳ��Ϣ
		PageHelper.startPage(page, limit);
		//ִ�в�ѯ
		List<User> list = userMapper.selectAllUser(aid,equName);
		//����һ������ֵ����
		DataResult result = new DataResult();
		result.setData(list);
		result.setMsg("");
		result.setCode(0);
		//ȡ��ҳ���
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		long total = pageInfo.getTotal();
		result.setTotal(total);
		return result;

	}

	
	//�޸�����
	public void updatePassword(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andTelEqualTo(user.getTel());
		userMapper.updateByExampleSelective(user, example);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void deleteUser(User user) {
		userMapper.deleteByPrimaryKey(user.getUid());
	}

	@Override
	public void insertUser(User user) {
		userMapper.insertSelective(user);
	}

	@Override
	public List<manySelect> getSelectUser(Integer aid,String mac) {
	    //�Ȼ�ȡ����ı�����
        //�ٻ�ȡmacά���ı�����
        //ѭ����������mac�ı�����ѡ��Ϊselect

		//��ѯ�������б���

		List<manySelect> users = userMapper.getSelectUser(aid,mac);
		if(mac!=null){
			//��ѯ��ǰ�豸����Ա
			List<manySelect> deviceUsers = userMapper.getSelectDeviceUser(aid,mac);
			for(manySelect duser :deviceUsers){
				for(manySelect user : users){
					if(duser.getValue().equals(user.getValue())){
						user.setSelected("selected");
						user.setDisabled("");
					}
				}
			}
		}
        return users;
    }

	@Override
	public void createPassword(String tel, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andTelEqualTo(tel);
		List<User> users = userMapper.selectByExample(example);
		User user = users.get(0);
		user.setPassword(password);
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<message> getUserMessage(String uid) {
		return userMapper.getUserMessage(uid);
	}
}
