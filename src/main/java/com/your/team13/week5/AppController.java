package com.your.team13.week5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppController {
	private static final Logger logger = Logger.getLogger("PrintBill");
	private StringBuilder buf;

	Plan plan;
	Customer customer;
	Calculate calculate;

	public AppController() {
	}

	public void run(String inputPlan, int callTime, int lineNumber) {
		customer = new Customer();

		customer.setPlan(getPlan(inputPlan));
		customer.setCallTime(callTime);
		customer.setlineNumber(lineNumber);

		calculate = new Calculate(customer);

		logger.log(Level.INFO, this.printBill());
	}

	public Plan getPlan(String inputPlan) {
		if ("gold".equalsIgnoreCase(inputPlan)) {
			this.plan = new Gold();
		} else if ("silver".equalsIgnoreCase(inputPlan)) {
			this.plan = new Silver();
		}

		return this.plan;
	}

	public String printBill() {
		buf = new StringBuilder("\n===============================\n");
		buf.append("\t\t<Phone Bill>\n\n");
		buf.append("Plan : " + customer.getPlan().getPlanName() + "\n");
		buf.append("Minutes Used : " + customer.getCallTime() + "\n");
		buf.append("Number of Lines : " + customer.getlineNumber() + "\n\n");
		buf.append("Total Rate : " + calculate.totalRate() + "\n");
		buf.append("===============================");
		
		return buf + "";
	}
}
