/*
 * Author: Stefan Andritoiu <stefan.andritoiu@gmail.com>
 * Copyright (c) 2017 Intel Corporation.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

public class DS2413Sample {

	public static void main(String[] args) throws InterruptedException {
		// ! [Interesting]

		// Instantiate a DS2413 Module on a Dallas 1-wire bus connected to UART
		// 0
		upm_ds2413.DS2413 sensor = new upm_ds2413.DS2413(0);

		// find all of the DS2413 devices present on the bus
		sensor.init();

		// how many devices were found?
		System.out.println("Found " + sensor.devicesFound() + " device(s)");

		// read the gpio and latch values from the first device
		// the lower 4 bits are of the form:
		// <gpioB latch> <gpioB value> <gpioA latch> <gpioA value>
		System.out.println("GPIO device 0 values: " + sensor.readGpios(0));

		// set the gpio latch values of the first device
		System.out.println("Setting GPIO latches to on");
		sensor.writeGpios(0, 0x03);

		System.out.println("Exiting...");

		// ! [Interesting]
	}
}
