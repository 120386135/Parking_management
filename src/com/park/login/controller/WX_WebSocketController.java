package com.park.login.controller;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WX_WebSocketController {

	// ��¼��ǰ��������
		private static int onlineCount = 0;
		// CopyOnWriteArraySet�ǰ�ȫ��set���ϣ�������ſͻ��˵�ÿ��websocket����
		private static CopyOnWriteArraySet<WX_WebSocketController> set = new CopyOnWriteArraySet<WX_WebSocketController>();
		// ��ͻ��˵����ӻỰ
		private Session session;
		// ���ص���Ϣ
		private String message;
		// ��ǰ�û����߳�����
		private String username;
	 
		/**
		 * ���ӽ����ɹ����õķ���
		 * @param session  ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
		 */
		@OnOpen
		public void onOpen(Session session) throws IOException {
			// ��ʼ��session
			this.session = session;
			// ����ǰsession��ӵ�set������
			set.add(this);				
			// ����������1
			onlineCount++;
			// �޸ĵ�ǰ�̵߳�����
			Thread.currentThread().setName("�û�" + onlineCount);
			// ��ȡ��ǰ�̵߳�����
			username = Thread.currentThread().getName();
			// ��д���ص���Ϣ
			message = username + "��¼�ɹ�����ǰ��������Ϊ��" + onlineCount + "��";
			// Ⱥ����Ϣ
			for (WX_WebSocketController websocketTomcat : set) {
				websocketTomcat.session.getBasicRemote().sendText(message);
			}
		}
	 
		/**
		 * ���ӹرյ��õķ���
		 */
		@OnClose
		public void onClose() throws IOException {
			// ����ǰsession��set�������Ƴ�
			set.remove(this);
			// ����������1
			onlineCount--;
			// ��д���ص���Ϣ
			message = username + "���߳ɹ�,��ǰ��������Ϊ��" + onlineCount + "��";
			// �ж�set�������Ƿ���websocket����
			if (set.size() > 0) {
				// Ⱥ����Ϣ
				for (WX_WebSocketController websocketTomcat : set) {
					websocketTomcat.session.getBasicRemote().sendText(message);
				}
			}
		}
	 
		/**
		 * ���ӹرյ��õķ���
		 */
		@OnError
		public void onError(Throwable error) {
			error.printStackTrace();
		}
	 
		/**
		 * �յ��ͻ�����Ϣ����õķ���
		 * @param message �ͻ��˷��͹�������Ϣ
		 * @param session ��ѡ�Ĳ���
		 */
		@OnMessage
		public void onMessage(String message) throws IOException {
			// Ⱥ����Ϣ
			for (WX_WebSocketController websocketTomcat : set) {
				websocketTomcat.session.getBasicRemote().sendText(message);
			}
		}

}
