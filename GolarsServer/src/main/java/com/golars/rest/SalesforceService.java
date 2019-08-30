package com.golars.rest;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.golars.util.DBUtil;


public class SalesforceService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
public void init() throws ServletException {
	super.init();
	System.out.println("********************** salesforce thread started");
	startForFirstTime();
}
private void startForFirstTime() {
	Timer t = new Timer();
	t.scheduleAtFixedRate(new TimerTask() {
		@Override
		public void run() {
			DBUtil.getInstance().fetchAndSubmitToSalesForce();

		}

	}, 3600000, 3600000);
	
}
}
