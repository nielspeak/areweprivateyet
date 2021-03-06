// Copyright 2013 Evidon.  All rights reserved.
// Use of this source code is governed by a Apache License 2.0
// license that can be found in the LICENSE file.

package com.evidon.areweprivateyet;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class CrawlusInterruptus extends Thread {

	final private int timeout;

	public CrawlusInterruptus(int seconds) {
		this.timeout = seconds;
	}

	public void run() {
		try {
			Thread.sleep(timeout * 1000);

			/* Timeout occurred */
			// CrawlusInterruptus.save(new TimeoutException("Time out occured waiting for page to load"));

			/* Stop WebDriver.get */
			System.out.println("Hard interrupt tripped, sending Escape key");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);

		} catch (InterruptedException ex) {
			return;
		} catch (AWTException ex) {
			System.out.println("Error occurned pressing ESC");
			ex.printStackTrace();
		}
	}
}
