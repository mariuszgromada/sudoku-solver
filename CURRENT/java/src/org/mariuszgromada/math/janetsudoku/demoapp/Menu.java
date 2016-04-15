/*
 * @(#)Menu.java        1.0.0    2016-04-15
 *
 * You may use this software under the condition of "Simplified BSD License"
 *
 * Copyright 2016 MARIUSZ GROMADA. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY <MARIUSZ GROMADA> ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of MARIUSZ GROMADA.
 *
 * If you have any questions/bugs feel free to contact:
 *
 *     Mariusz Gromada
 *     mariusz.gromada@mathspace.pl
 *     http://mathspace.pl/
 *     http://mathparser.org/
 *     http://github.com/mariuszgromada/java-utils
 *     http://github.com/mariuszgromada/MathParser.org-mXparser
 *     http://mariuszgromada.github.io/MathParser.org-mXparser/
 *     http://mxparser.sourceforge.net/
 *     http://bitbucket.org/mariuszgromada/mxparser/
 *     http://mxparser.codeplex.com/
 *
 *                              Asked if he believes in one God, a mathematician answered:
 *                              "Yes, up to isomorphism."
 */
package org.mariuszgromada.math.janetsudoku.demoapp;

/**
 * Package level class for command line menu.
 *
 * @author         <b>Mariusz Gromada</b><br>
 *                 <a href="mailto:mariusz.gromada@mathspace.pl">mariusz.gromada@mathspace.pl</a><br>
 *                 <a href="http://mathspace.pl/" target="_blank">MathSpace.pl</a><br>
 *                 <a href="http://mathparser.org/" target="_blank">MathParser.org - mXparser project page</a><br>
 *                 <a href="http://github.com/mariuszgromada/java-utils" target="_blank">Java-Utils on GitHub</a><br>
 *                 <a href="http://github.com/mariuszgromada/MathParser.org-mXparser" target="_blank">mXparser on GitHub</a><br>
 *                 <a href="http://mariuszgromada.github.io/MathParser.org-mXparser/" target="_blank">mXparser on GitHub pages</a><br>
 *                 <a href="http://mxparser.sourceforge.net/" target="_blank">mXparser on SourceForge</a><br>
 *                 <a href="http://bitbucket.org/mariuszgromada/mxparser/" target="_blank">mXparser on Bitbucket</a><br>
 *                 <a href="http://mxparser.codeplex.com/" target="_blank">mXparser on CodePlex</a><br>
 *
 * @version        1.0.0
 */
class Menu {
	/**
	 * Menu title.
	 */
	String title;
	/**
	 * Items number in the menu.
	 */
	int itemsNum;
	/**
	 * Menu content
	 */
	String[] content;
	/**
	 * Instance of the root JanetSudoku class (demo app)
	 */
	JanetSudoku janetSudoku;
	/**
	 * Default constructor.
	 * @param title           Menu title {@link MenuData}.
	 * @param content         Menu content {@link MenuData}.
	 * @param janetSudoku     Root JanetSudoku class with demo app {@link JanetSudoku}.
	 * @see MenuData
	 * @see JanetSudoku
	 */
	Menu(String title, String[] content, JanetSudoku janetSudoku) {
		this.title = title;
		this.itemsNum = content.length - 1;
		this.content = content;
		this.janetSudoku = janetSudoku;
	}
	/**
	 * Prints menu to the console.
	 */
	void consolePrintMenue() {
		janetSudoku.consolePrintPuzzle();
		Console.println();
		Console.println("----- " + title + " -----");
		for (int i = 3; i <= itemsNum; i++) {
			Console.println(content[i]);
		}
		Console.println("----- " + "General" + " -----");
		Console.println(content[1]);
		Console.println(content[2]);
		Console.println(content[0]);
	}
	/**
	 * Ask user for menu item selection.
	 * @return  Select item id {@link MenuData}.
	 *
	 * @see MenuData
	 */
	int getItem() {
		int selItem = 0;
		boolean loop = true;
		do {
			consolePrintMenue();
			Console.println();
			Console.print("Your selection: ");
			selItem = Console.readInt();
			if ((selItem >= 0) && (selItem <= itemsNum)) loop = false;
			else Console.println(">>> !!! Please select correct menu item. !!! <<<");
		} while (loop == true);
		return selItem;
	}
}