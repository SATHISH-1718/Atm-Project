package com.notification;

import com.atm.Card;

public interface Notification {
	public abstract void sendMessage(Card card,double amount,String date,String time,String type);

}
