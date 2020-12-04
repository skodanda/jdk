/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
import javax.swing.JCheckBoxMenuItem;  
import javax.swing.JFrame;  
import javax.swing.JMenu;  
import javax.swing.JMenuBar;  
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/* @test
 * @bug 8031573 8040279 8143064
 * @summary [macosx] Checkmarks of JCheckBoxMenuItems aren't rendered
 *           in high resolution on Retina
 * @author Alexander Scherbatiy
 * @run main bug8031573
 */
 
public class bug8031573 {
    private JFrame frame;
    private JMenuBar bar;
    private JMenu menu;
    private JCheckBoxMenuItem checkBoxMenuItem;
    
    public static void main(String args[]) {
        bug8031573 test = new bug8031573();
        test.createGUI();
    }
    private void createGUI () {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    frame = new JFrame("bug8031573");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    bar = new JMenuBar();
                    menu = new JMenu("Menu");
                    checkBoxMenuItem = new JCheckBoxMenuItem("JCheckBoxMenuItem");
                    checkBoxMenuItem.setSelected(true);
                    menu.add(checkBoxMenuItem);
                    bar.add(menu);
                    frame.setJMenuBar(bar);
                    frame.setSize(350, 250);
                    frame.setVisible(true);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);    
        }
    }
}
