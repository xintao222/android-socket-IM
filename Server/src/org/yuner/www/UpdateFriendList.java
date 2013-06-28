package org.yuner.www;

import java.util.*;
import org.yuner.www.client.ClientActivity;
import org.yuner.www.client.UserInfo;

public class UpdateFriendList extends Thread{

	private Vector<ClientActivity> mClientV;
	private ClientActivity mNewone;
	private int mAct;

	/* cannot make any change to both mClientV and mNewone */
	public UpdateFriendList(Vector<ClientActivity> clientV, ClientActivity newone, int act) {
		mClientV = clientV;
		mNewone = newone;
		mAct = act;
	}

	@Override
	public void run() {
		String type56 = "!!!!!&&&!";
		String str = mAct + type56;
		str += mNewone.getUserInfo().toString() + type56;
		str += UserInfo.strSplitter;

		for(ClientActivity ca0 : mClientV) {
			if(ca0.getUserInfo().getId() != mNewone.getUserInfo().getId()) {
				ca0.sendOneString(str, 6);
			}
		}
	}

}