package com.notification;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.atm.Card;

public class ShortMessageService implements Notification{

	@Override
	public void sendMessage(Card card,double amount,String date,String time,String type) {
		// TODO Auto-generated method stub
		String debit="Rs. "+amount+" has been DEBITED to your A/c XXXX"+card.getCardNumber()%10000+" on "+date+"."
				+ "\n Avl Bal INR "+card.getBalance()
				+ ".To report fraud & stop further debit SMS SUSPECT to 56161- Canara Bank";
		String credit="An amount of INR "+amount+" has been CREDITED to your account XXXX"+card.getCardNumber()%10000+" "
				+ "\non "+date+"."
				+ "Total Avail.bal INR "+card.getBalance()+".- Canara Bank";
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter("notification.txt"))) {
			 if(type.equals("Debit"))
	            writer.write(debit);
			 else
				 writer.write(credit);
	            writer.close();
	        } catch (IOException e) {
	            System.err.println("Error writing OTP to file: " + e.getMessage());
	        }
		
	}
}
