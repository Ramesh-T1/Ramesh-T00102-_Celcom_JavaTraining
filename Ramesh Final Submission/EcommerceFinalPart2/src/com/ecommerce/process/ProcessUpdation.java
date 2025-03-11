package com.ecommerce.process;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.dboperations.InProgress;
import com.dboperations.PendingPayment;
import com.ecommerce.connection.DBConnection;

public class ProcessUpdation extends Thread {
	static Connection con;
	static {
		// To establish connection with Oracle DB creating object
		DBConnection dbp = new DBConnection(con);
		con=dbp.dbConnection();
	}

	public void run() {
		// To mark all New orders status to InProgress
		InProgress ip = new InProgress();
		ip.markInProgress(con);
		// To mark status to PendingPayment and call to final payment process
		// Updating qty based on availability in producdetails table
		PendingPayment pp = new PendingPayment();
		pp.markPendingPayment(con);
	}

	public static void main(String[] args) {
		//DBConnection dbp = new DBConnection(con);
		ScheduledExecutorService es = Executors.newScheduledThreadPool(10000);
		ProcessUpdation ops = new ProcessUpdation();
		/*ExecutorService esd=Executors.newCachedThreadPool();
		esd.execute(ops);
		esd.shutdown();*/
		es.scheduleAtFixedRate(ops, 20, 30, TimeUnit.SECONDS);
		//es.shutdown();
		es.schedule(() -> {
		    es.shutdown();
		    System.out.println("Executor shut down.");
		}, 120, TimeUnit.SECONDS);
		
	}

}
