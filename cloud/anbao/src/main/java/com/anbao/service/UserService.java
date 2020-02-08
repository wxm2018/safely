package com.anbao.service;

import java.util.List;

import com.anbao.pojo.User;
import com.anbao.pojo.DataResult;
import com.anbao.pojo.manySelect;
import com.anbao.pojo.message;

public interface UserService {
	//��ѯ�����б�

	//����tel����User
	public User getUserByTel(String tel);
	
	//ע���û�
	public String updataUser(User user);

	//��ѯ�û��б�
	public DataResult selectAllUser(Integer page, Integer limit,Integer aid,String equName);

	//�޸�����
	public void updatePassword(User user);

	void updateUser(User user);

    void deleteUser(User user);

    void insertUser(User user);

    List<manySelect> getSelectUser(Integer aid,String mac);

    void createPassword(String tel, String password);

    List<message> getUserMessage(String uid);
}
