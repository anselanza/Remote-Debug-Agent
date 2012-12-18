/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package remotedebug;


import processing.core.*;
import java.io.*;

/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own library or tool naming convention.
 * 
 * @example Hello 
 * 
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class RemoteDebugAgent {
	
	// myParent is a reference to the parent sketch
	PApplet myParent;
	FileWriter fw;
	String logFileName;
	boolean LOCAL_ECHO; // if true, the library will echo debugging strings to the console
	
	public final static String VERSION = "0.1";
	

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example Hello
	 * @param theParent
	 */
	public RemoteDebugAgent(PApplet theParent) {
		myParent = theParent;
		LOCAL_ECHO = true;
		welcome();
		//logFileName = myParent.dataPath("") + "/rd.log";
		logFileName = "/tmp/rd.log";
		log("======== RESTARTED LOG FILE", false);
	}
	
	
	private void welcome() {
		System.out.println("Remote Debug Agent" + VERSION + "by Stephen Buchanan");
		System.out.println("LOCAL_ECHO: " + LOCAL_ECHO);
		System.out.println("====================================================");
	}
	
	
	public String sayHello() {
		return "hello library.";
	}
	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	public void log(String s) {
		log(s, true);
	}
	
	public void log(String s, boolean append) {
		 
		try
		{
			if (append) { 
				fw = new FileWriter(logFileName,true);
			} else {
				fw = new FileWriter(logFileName,false);
			}
			System.out.println("Debug Agent writing : " + s);
			fw.write(s+"\n");//appends the string to the file
			fw.close();
		}
		catch(IOException ioe)
		{
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
}

