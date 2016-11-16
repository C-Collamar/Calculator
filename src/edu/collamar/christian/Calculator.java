/**
 * APPLICATION RESTRAINTS:
 *   - Can only stack a maximum of 100 character-operation
 *   - Can only stack a maximum of 100 double tokens (i.e. numbers)
 */

package edu.collamar.christian;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator {
	
	private JFrame frame;
	private String infix = "";
	private String answer = "0";
	private boolean clearScreen = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculator() {
		initialize();
		process();
	}

	private void initialize() {
		frame = new JFrame("Simple Calculator");
		frame.getContentPane().setBackground(SystemColor.textInactiveText);
		frame.setLocationRelativeTo(null);
		frame.setSize(320, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	private void process() {
		JLabel outputScreen = new JLabel("");
		outputScreen.setForeground(Color.DARK_GRAY);
		outputScreen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		outputScreen.setBackground(Color.WHITE);
		outputScreen.setBounds(5, 32, 295, 43);
		outputScreen.setHorizontalAlignment(JTextField.RIGHT);
		outputScreen.setOpaque(true);
		frame.getContentPane().add(outputScreen);

		JTextField history_bar;
		history_bar = new JTextField("history goes here...");
		history_bar.setBackground(new Color(230, 230, 250));
		history_bar.setHorizontalAlignment(JTextField.CENTER);
		history_bar.setEditable(false);
		history_bar.setBounds(5, 5, 295, 20);
		frame.getContentPane().add(history_bar);
		history_bar.setColumns(10);

/*************************************************************************************/
/*********************     THIS CODE SECTION IS FOR BUTTONS     **********************/
/*************************************************************************************/
		
		//panel for grouping basic calculator buttons
		JPanel basicButtonsPanel = new JPanel();
		basicButtonsPanel.setBounds(5, 81, 236, 155);
		frame.getContentPane().add(basicButtonsPanel);
		basicButtonsPanel.setLayout(null);
		
				JButton button_0 = new JButton("0");
				button_0.setBounds(59, 124, 59, 31);
				basicButtonsPanel.add(button_0);
				button_0.setBackground(Color.GRAY);
				button_0.setForeground(SystemColor.text);
				button_0.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_1 = new JButton("1");
				button_1.setBounds(0, 31, 59, 31);
				basicButtonsPanel.add(button_1);
				button_1.setBackground(Color.GRAY);
				button_1.setForeground(SystemColor.text);
				button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_2 = new JButton("2");
				button_2.setBounds(59, 31, 59, 31);
				basicButtonsPanel.add(button_2);
				button_2.setBackground(Color.GRAY);
				button_2.setForeground(SystemColor.text);
				button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_3 = new JButton("3");
				button_3.setBounds(118, 31, 59, 31);
				basicButtonsPanel.add(button_3);
				button_3.setBackground(Color.GRAY);
				button_3.setForeground(SystemColor.text);
				button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_4 = new JButton("4");
				button_4.setBounds(0, 62, 59, 31);
				basicButtonsPanel.add(button_4);
				button_4.setBackground(Color.GRAY);
				button_4.setForeground(SystemColor.text);
				button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_5 = new JButton("5");
				button_5.setBounds(59, 62, 59, 31);
				basicButtonsPanel.add(button_5);
				button_5.setBackground(Color.GRAY);
				button_5.setForeground(SystemColor.text);
				button_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_6 = new JButton("6");
				button_6.setBounds(118, 62, 59, 31);
				basicButtonsPanel.add(button_6);
				button_6.setBackground(Color.GRAY);
				button_6.setForeground(SystemColor.text);
				button_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_7 = new JButton("7");
				button_7.setBounds(0, 93, 59, 31);
				basicButtonsPanel.add(button_7);
				button_7.setBackground(Color.GRAY);
				button_7.setForeground(SystemColor.text);
				button_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_8 = new JButton("8");
				button_8.setBounds(59, 93, 59, 31);
				basicButtonsPanel.add(button_8);
				button_8.setBackground(Color.GRAY);
				button_8.setForeground(SystemColor.text);
				button_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_9 = new JButton("9");
				button_9.setBounds(118, 93, 59, 31);
				basicButtonsPanel.add(button_9);
				button_9.setBackground(Color.GRAY);
				button_9.setForeground(SystemColor.text);
				button_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_divide = new JButton("/");
				button_divide.setBounds(177, 124, 59, 31);
				basicButtonsPanel.add(button_divide);
				button_divide.setBackground(new Color(52, 64, 84));
				button_divide.setForeground(Color.WHITE);
				button_divide.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_multiply = new JButton("*");
				button_multiply.setBounds(177, 93, 59, 31);
				basicButtonsPanel.add(button_multiply);
				button_multiply.setBackground(new Color(52, 64, 84));
				button_multiply.setForeground(Color.WHITE);
				button_multiply.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_add = new JButton("+");
				button_add.setBounds(177, 31, 59, 31);
				basicButtonsPanel.add(button_add);
				button_add.setBackground(new Color(52, 64, 84));
				button_add.setForeground(SystemColor.text);
				
				JButton button_subtract = new JButton("-");
				button_subtract.setBounds(177, 62, 59, 31);
				basicButtonsPanel.add(button_subtract);
				button_subtract.setBackground(new Color(52, 64, 84));
				button_subtract.setForeground(Color.WHITE);
				button_add.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_subtract.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_decimal = new JButton(".");
				button_decimal.setBounds(0, 124, 59, 31);
				basicButtonsPanel.add(button_decimal);
				button_decimal.setBackground(SystemColor.textInactiveText);
				button_decimal.setForeground(SystemColor.text);
				button_decimal.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_opening = new JButton("(");
				button_opening.setBounds(0, 0, 59, 31);
				basicButtonsPanel.add(button_opening);
				button_opening.setForeground(SystemColor.text);
				button_opening.setBackground(SystemColor.controlDkShadow);
				button_opening.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_closing = new JButton(")");
				button_closing.setBounds(59, 0, 59, 31);
				basicButtonsPanel.add(button_closing);
				button_closing.setForeground(SystemColor.text);
				button_closing.setBackground(SystemColor.controlDkShadow);
				button_closing.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JButton button_percent = new JButton("%");
				button_percent.setBounds(118, 0, 59, 31);
				basicButtonsPanel.add(button_percent);
				button_percent.setForeground(Color.WHITE);
				button_percent.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_percent.setBackground(new Color(52, 64, 84));
				
				JButton button_sqrt = new JButton("\u221A");
				button_sqrt.setBounds(177, 0, 59, 31);
				basicButtonsPanel.add(button_sqrt);
				button_sqrt.setForeground(Color.WHITE);
				button_sqrt.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_sqrt.setBackground(new Color(52, 64, 84));
				
				JButton button_powerOf = new JButton("<html>n<sup>x</sup></html>");
				button_powerOf.setBounds(118, 124, 59, 31);
				basicButtonsPanel.add(button_powerOf);
				button_powerOf.setForeground(Color.WHITE);
				button_powerOf.setBackground(new Color(52, 64, 84));
				button_powerOf.setFont(new Font("Tahoma", Font.PLAIN, 12));

				//actions for the above buttons in the basicButtonsPanel
				button_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "9");
						infix = outputScreen.getText();
					}
				});
				button_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "8");
						infix = outputScreen.getText();
					}
				});
				button_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "7");
						infix = outputScreen.getText();
					}
				});
				button_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "6");
						infix = outputScreen.getText();
					}
				});
				button_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "5");
						infix = outputScreen.getText();
					}
				});
				button_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "4");
						infix = outputScreen.getText();
					}
				});
				button_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "3");
						infix = outputScreen.getText();
					}
				});
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "2");
						infix = outputScreen.getText();
					}
				});
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "1");
						infix = outputScreen.getText();
					}
				});
				button_0.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "0");
						infix = outputScreen.getText();
					}
				});
				button_divide.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clearScreen = false;
						outputScreen.setText(outputScreen.getText() + "/");
						infix = outputScreen.getText();
					}
				});
				button_multiply.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clearScreen = false;
						outputScreen.setText(outputScreen.getText() + "*");
						infix = outputScreen.getText();
					}
				});
				button_add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						clearScreen = false;
						outputScreen.setText(outputScreen.getText() + "+");
						infix = outputScreen.getText();
					}
				});
				button_subtract.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clearScreen = false;
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "-");
						infix = outputScreen.getText();
					}
				});
				button_decimal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + ".");
						infix = outputScreen.getText();
					}
				});
				button_opening.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "(");
						infix = outputScreen.getText();
					}
				});
				button_closing.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + ")");
						infix = outputScreen.getText();
					}
				});
				button_percent.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "%");
						infix = outputScreen.getText();
					}
				});
				button_powerOf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "^");
						infix = outputScreen.getText();
					}
				});
				button_sqrt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "\u221A");
						infix = outputScreen.getText();
					}
				});

		//panel for grouping scientific calculator buttons
		JPanel scientificButtonsPanel = new JPanel();
		scientificButtonsPanel.setBounds(241, 81, 59, 154);
		scientificButtonsPanel.setVisible(false);
		frame.getContentPane().add(scientificButtonsPanel);
		scientificButtonsPanel.setLayout(null);
		
				JButton button_factorial = new JButton("!");
				button_factorial.setBounds(0, 0, 59, 31);
				scientificButtonsPanel.add(button_factorial);
				button_factorial.setForeground(Color.WHITE);
				button_factorial.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_factorial.setBackground(new Color(79, 58, 56));
				
				JButton button_pi = new JButton("\u03C0");
				button_pi.setBounds(0, 31, 59, 31);
				scientificButtonsPanel.add(button_pi);
				button_pi.setForeground(Color.WHITE);
				button_pi.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_pi.setBackground(new Color(79, 58, 56));
				
				JButton button_sin = new JButton("sin");
				button_sin.setBounds(0, 61, 59, 31);
				scientificButtonsPanel.add(button_sin);
				button_sin.setForeground(Color.WHITE);
				button_sin.setFont(new Font("Tahoma", Font.PLAIN, 15));
				button_sin.setBackground(new Color(79, 58, 56));
				
				JButton button_cos = new JButton("cos");
				button_cos.setBounds(0, 92, 59, 31);
				scientificButtonsPanel.add(button_cos);
				button_cos.setForeground(Color.WHITE);
				button_cos.setFont(new Font("Tahoma", Font.PLAIN, 15));
				button_cos.setBackground(new Color(79, 58, 56));
				
				JButton button_tan = new JButton("tan");
				button_tan.setBounds(0, 123, 59, 31);
				scientificButtonsPanel.add(button_tan);
				button_tan.setForeground(Color.WHITE);
				button_tan.setFont(new Font("Tahoma", Font.PLAIN, 15));
				button_tan.setBackground(new Color(79, 58, 56));
				
				//actions for the scientific buttons
				button_factorial.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "!");
						infix = outputScreen.getText();
					}
				});
				button_pi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "\u03C0");
						infix = outputScreen.getText();
					}
				});
				button_sin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "sin");
						infix = outputScreen.getText();
					}
				});
				button_cos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "cos");
						infix += outputScreen.getText();
					}
				});
				button_tan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(clearScreen) {
							outputScreen.setText("");
							clearScreen = false;
						}
						outputScreen.setText(outputScreen.getText() + "tan");
						infix += outputScreen.getText();
					}
				});

		//panel for grouping the general calculator buttons
		JPanel fundamentalCalculatorButtonsPanel = new JPanel();
		fundamentalCalculatorButtonsPanel.setBounds(241, 81, 59, 155);
		frame.getContentPane().add(fundamentalCalculatorButtonsPanel);
		fundamentalCalculatorButtonsPanel.setLayout(null);
		
				JButton button_del = new JButton("DEL");
				button_del.setBounds(0, 0, 59, 31);
				fundamentalCalculatorButtonsPanel.add(button_del);
				button_del.setForeground(Color.WHITE);
				button_del.setBackground(Color.DARK_GRAY);
				button_del.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
				JButton button_clear = new JButton("C");
				button_clear.setBounds(0, 31, 59, 31);
				fundamentalCalculatorButtonsPanel.add(button_clear);
				button_clear.setBackground(new Color(189, 87, 77));
				button_clear.setForeground(Color.WHITE);
				button_clear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
				JButton button_prevAnswer = new JButton("ANS");
				button_prevAnswer.setForeground(Color.WHITE);
				button_prevAnswer.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_prevAnswer.setBackground(new Color(86, 136, 216));
				button_prevAnswer.setBounds(0, 62, 59, 31);
				fundamentalCalculatorButtonsPanel.add(button_prevAnswer);
				
				JButton button_equals = new JButton("=");
				button_equals.setBounds(0, 93, 59, 62);
				fundamentalCalculatorButtonsPanel.add(button_equals);
				button_equals.setBackground(new Color(217, 128, 68));
				button_equals.setForeground(SystemColor.text);
				button_equals.setFont(new Font("Tahoma", Font.PLAIN, 15));

				//actions for buttons of fundamentalCalculatorButtonsPanel
				button_del.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(outputScreen.getText().length() > 0)
							outputScreen.setText(outputScreen.getText().substring(0, outputScreen.getText().length() - 1));
							infix = outputScreen.getText();
					}
				});
				button_clear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						outputScreen.setText("");
						infix = "";
					}
				});
				button_prevAnswer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						outputScreen.setText(answer);
					}
				});
				button_equals.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						history_bar.setText(outputScreen.getText());
						try {
							outputScreen.setText(processPostfix(convertToPostfix(infix)));
							answer = outputScreen.getText();
						} catch(Exception pen_pineapple) {
							outputScreen.setText("Syntax error");
						}
						clearScreen = true;
					}
				});

/*************************************************************************************/
/***************     THIS CODE SECTION IS FOR THE MENU     ***************************/
/*************************************************************************************/

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu options = new JMenu("Options");
		menuBar.add(options);
		
		JMenu themes = new JMenu("Themes");
		options.add(themes);

		JCheckBoxMenuItem DarkTheme = new JCheckBoxMenuItem("Dark theme");	
		DarkTheme.setSelected(true);
		themes.add(DarkTheme);
		JCheckBoxMenuItem LightTheme = new JCheckBoxMenuItem("Light theme");
		themes.add(LightTheme);
		
		JMenu about = new JMenu("About");
		menuBar.add(about);
		
		JMenuItem features = new JMenuItem("Features");
		about.add(features);
		
		JMenuItem team = new JMenuItem("Team");
		about.add(team);
		
		features.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(new File(Paths.get("").toAbsolutePath().toString() + "\\Calculator_info.txt"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		LightTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarkTheme.setSelected(false);
				LightTheme.setSelected(true);
				
				frame.getContentPane().setBackground(new Color(230, 230, 250));
				history_bar.setBackground(SystemColor.white);
				
				button_0.setBackground(new Color(220, 220, 220));
				button_0.setForeground(Color.BLACK);
				button_1.setBackground(new Color(220, 220, 220));
				button_1.setForeground(Color.BLACK);
				button_2.setBackground(new Color(220, 220, 220));
				button_2.setForeground(Color.BLACK);
				button_3.setBackground(new Color(220, 220, 220));
				button_3.setForeground(Color.BLACK);
				button_4.setBackground(new Color(220, 220, 220));
				button_4.setForeground(Color.BLACK);
				button_5.setBackground(new Color(220, 220, 220));
				button_5.setForeground(Color.BLACK);
				button_6.setBackground(new Color(220, 220, 220));
				button_6.setForeground(Color.BLACK);
				button_7.setBackground(new Color(220, 220, 220));
				button_7.setForeground(Color.BLACK);
				button_8.setBackground(new Color(220, 220, 220));
				button_8.setForeground(Color.BLACK);
				button_9.setBackground(new Color(220, 220, 220));
				button_9.setForeground(Color.BLACK);
				
				button_opening.setForeground(SystemColor.BLACK);
				button_opening.setBackground(new Color(169, 169, 169));
				button_closing.setForeground(SystemColor.BLACK);
				button_closing.setBackground(new Color(169, 169, 169));
				button_decimal.setForeground(SystemColor.BLACK);
				button_decimal.setBackground(new Color(169, 169, 169));
				
				button_percent.setForeground(new Color(234, 234, 234));
				button_percent.setBackground(new Color(93, 103, 124));
				button_sqrt.setForeground(new Color(234, 234, 234));
				button_sqrt.setBackground(new Color(93, 103, 124));
				button_add.setForeground(new Color(234, 234, 234));
				button_add.setBackground(new Color(93, 103, 124));
				button_subtract.setForeground(new Color(234, 234, 234));
				button_subtract.setBackground(new Color(93, 103, 124));
				button_multiply.setForeground(new Color(234, 234, 234));
				button_multiply.setBackground(new Color(93, 103, 124));
				button_divide.setForeground(new Color(234, 234, 234));
				button_divide.setBackground(new Color(93, 103, 124));
				button_powerOf.setForeground(new Color(234, 234, 234));
				button_powerOf.setBackground(new Color(93, 103, 124));
				
				button_factorial.setForeground(new Color(234, 234, 234));
				button_factorial.setBackground(new Color(127, 99, 94));
				button_pi.setForeground(new Color(234, 234, 234));
				button_pi.setBackground(new Color(127, 99, 94));
				button_sin.setForeground(new Color(234, 234, 234));
				button_sin.setBackground(new Color(127, 99, 94));
				button_cos.setForeground(new Color(234, 234, 234));
				button_cos.setBackground(new Color(127, 99, 94));
				button_tan.setForeground(new Color(234, 234, 234));
				button_tan.setBackground(new Color(127, 99, 94));
				
				button_del.setForeground(new Color(234, 234, 234));
				button_del.setBackground(Color.GRAY);
				button_clear.setForeground(new Color(234, 234, 234));
				button_clear.setBackground(new Color(186, 120, 113));
				button_prevAnswer.setForeground(new Color(234, 234, 234));
				button_prevAnswer.setBackground(new Color(106, 136, 186));
				button_equals.setForeground(new Color(234, 234, 234));
				button_equals.setBackground(new Color(198, 144, 107));
			}
		});

		DarkTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(SystemColor.textInactiveText);
				DarkTheme.setSelected(true);
				LightTheme.setSelected(false);
				
				button_0.setBackground(Color.GRAY);
				button_0.setForeground(SystemColor.text);
				button_1.setBackground(Color.GRAY);
				button_1.setForeground(SystemColor.text);
				button_2.setBackground(Color.GRAY);
				button_2.setForeground(SystemColor.text);
				button_3.setBackground(Color.GRAY);
				button_3.setForeground(SystemColor.text);
				button_4.setBackground(Color.GRAY);
				button_4.setForeground(SystemColor.text);
				button_5.setBackground(Color.GRAY);
				button_5.setForeground(SystemColor.text);
				button_6.setBackground(Color.GRAY);
				button_6.setForeground(SystemColor.text);
				button_7.setBackground(Color.GRAY);
				button_7.setForeground(SystemColor.text);
				button_8.setBackground(Color.GRAY);
				button_8.setForeground(SystemColor.text);
				button_9.setBackground(Color.GRAY);
				button_9.setForeground(SystemColor.text);
				
				
				button_opening.setForeground(SystemColor.text);
				button_opening.setBackground(SystemColor.controlDkShadow);
				button_closing.setForeground(SystemColor.text);
				button_closing.setBackground(SystemColor.controlDkShadow);
				button_decimal.setForeground(SystemColor.text);
				button_decimal.setBackground(SystemColor.controlDkShadow);				

				button_sqrt.setForeground(SystemColor.text);
				button_sqrt.setBackground(new Color(52, 64, 84));
				button_percent.setForeground(SystemColor.text);
				button_percent.setBackground(new Color(52, 64, 84));
				button_add.setForeground(Color.WHITE);
				button_add.setBackground(new Color(52, 64, 84));
				button_subtract.setForeground(Color.WHITE);
				button_subtract.setBackground(new Color(52, 64, 84));
				button_multiply.setForeground(Color.WHITE);
				button_multiply.setBackground(new Color(52, 64, 84));
				button_divide.setForeground(Color.WHITE);
				button_divide.setBackground(new Color(52, 64, 84));
				button_powerOf.setForeground(Color.WHITE);
				button_powerOf.setBackground(new Color(52, 64, 84));

				button_factorial.setForeground(Color.WHITE);
				button_factorial.setBackground(new Color(79, 58, 56));
				button_pi.setForeground(Color.WHITE);
				button_pi.setBackground(new Color(79, 58, 56));
				button_sin.setForeground(Color.WHITE);
				button_sin.setBackground(new Color(79, 58, 56));
				button_cos.setForeground(Color.WHITE);
				button_cos.setBackground(new Color(79, 58, 56));
				button_tan.setForeground(Color.WHITE);
				button_tan.setBackground(new Color(79, 58, 56));
				
				button_del.setForeground(SystemColor.WHITE);
				button_del.setBackground(Color.DARK_GRAY);
				button_clear.setForeground(SystemColor.WHITE);
				button_clear.setBackground(new Color(189, 87, 77));
				button_prevAnswer.setForeground(SystemColor.WHITE);
				button_prevAnswer.setBackground(new Color(86, 136, 216));
				button_equals.setForeground(SystemColor.text);
				button_equals.setBackground(new Color(217, 128, 68));
			}
		});
		
		JMenu type = new JMenu("Type");
		options.add(type);
		
		JCheckBoxMenuItem basic = new JCheckBoxMenuItem("Basic");
		JCheckBoxMenuItem scientific = new JCheckBoxMenuItem("Scientific");
		
		basic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(scientific.isSelected())) {
					basic.setSelected(true);
				}
				else {
					frame.setSize(320, 301);
					
					outputScreen.setBounds(5, 32, 295, 43);
					history_bar.setBounds(5, 5, 295, 20);
					
					scientific.setSelected(false);
					
					fundamentalCalculatorButtonsPanel.setBounds(241, 81, 59, 154);
					scientificButtonsPanel.setVisible(false);
				}
			}
		});
		basic.setSelected(true);
		type.add(basic);
		
		scientific.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(basic.isSelected())) {
					scientific.setSelected(true);
				}
				else {
					frame.setSize(378, 301);

					outputScreen.setBounds(5, 32, 351, 43);
					history_bar.setBounds(5, 5, 351, 20);
					
					fundamentalCalculatorButtonsPanel.setBounds(298, 81, 59, 155);
					scientificButtonsPanel.setVisible(true);
					basic.setSelected(false);
				}
				
			}
		});
		type.add(scientific);

	}

	private String convertToPostfix(String infix){
		// Output the infix expression to active console
		System.out.println("INFIX: " + infix);
		
		//parse infix expression to the right specification (for evaluation purposes)
		infix = infix.replaceAll("\u221A", "q")
				.replaceAll("\u03C0", "p")
				.replaceAll("sin", "s")
				.replaceAll("cos", "c")
				.replaceAll("tan", "t");
		
		//parse to add multiplication operation if user neglects to explicitly include multiplication sign 
		for(int x = 0, length = infix.length(); x < length; ++x) {
			switch(infix.charAt(x)) {
				//if a number precedes the opening parenthesis or sin/cos/tan functions
				case 'q': case 's': case 'c': case 't': case 'p': case'(':
					if((x != 0 && (infix.charAt(x - 1) >= '0' && infix.charAt(x-1) <= '9'))) {
						infix =  infix.substring(0, x) + "*" + infix.substring(x);
					}
					break;
				default: break;
			}
			//if a number follows pi constant
			if((x + 1 != length && infix.charAt(x) == 'p' &&
				infix.charAt(x + 1) >= '0' && infix.charAt(x + 1) <= '9')) {
					infix =  infix.substring(0, x + 1) + "*" + infix.substring(x + 1);
			}
			//if a decimal number is typed without a leading zero before the decimal point
			if(infix.charAt(x) == '.' && ((x == 0) || !(infix.charAt(x - 1) >= '0' && infix.charAt(x-1) <= '9'))) {System.out.println("hello");
				if(x > 0 && infix.charAt(x - 1) == 'p')
					infix =  infix.substring(0, x) + "*0" + infix.substring(x);
				else infix =  infix.substring(0, x) + "0" + infix.substring(x);System.out.println("hei");
			}
		}
		
		//just printing out the result of the initial parsing for fun
		System.out.println("INFIX: " +infix.replaceAll("q", "\u221A").replaceAll("p", "\u03C0")
				.replaceAll("s", "sin").replaceAll("c", "cos").replaceAll("t", "tan"));
		
		OpStack stack = new OpStack('(');
		String postfix = "";
		infix += ")";
		int length = infix.length();
		
		for(int x = 0; x < length; ++x) {
			//if a positive/negative signs are encountered (to avoid confusion from addition/subtraction operation)
			if((infix.charAt(x) == '-' || infix.charAt(x) == '+') && (x == 0 ||
				infix.charAt(x - 1) < '0' || infix.charAt(x - 1) > '9'))
			{
				postfix += infix.charAt(x);
			}
			//if a constant (pi) or number/digit of a number is encountered
			else if((infix.charAt(x) >= '0' && infix.charAt(x) <= '9') || infix.charAt(x) == '.' || infix.charAt(x) == 'p') {
				do {
					postfix += infix.charAt(x++);
				} while(infix.charAt(x) >= '0' && infix.charAt(x) <= '9' || infix.charAt(x) == '.');
				postfix += " ";
				--x;
			}
			//if an opening parenthesis is encountered 
			else if(infix.charAt(x) == '(') {
				stack.push('(');
			}
			//if a closing parenthesis is encountered
			else if(infix.charAt(x) == ')') {
				while(stack.peek() != '(') {
					postfix +=stack.pop() + " ";
				}
				stack.pop();
			}
			//else if a unary operator is encountered
			else if(infix.charAt(x) == '!'  || infix.charAt(x) == '%') {
				postfix += infix.charAt(x) + " ";
			}
			//if an ordinary operator is encountered
			else {
				while(stack.topHasMorePriorityThan(infix.charAt(x))) {
					postfix += stack.pop() + " ";
				}
				stack.push(infix.charAt(x));
			}
		}
		
		postfix = postfix.substring(0, postfix.length() - 1);
		
		System.out.println("POSFIX EXPRESSION: " + postfix);
		return postfix;
	}
	
	private String processPostfix(String postfix) {
		String[] token = postfix.split(" ");
		NumStack stack = new NumStack();
		int size = token.length;

		for(int x = 0; x < size; ++x) {
			/** if an operation is encountered (additional conditional code
			 *  was made to distinguish negative sign from minus operation)
			 */
			if( token[x].equals("+") || (token[x].length() == 1 && token[x].equals("-")) ||
				token[x].equals("*") || token[x].equals("/") || token[x].equals("^"))
			{
				stack.push(evaluate(stack.pop(), stack.pop(), token[x].charAt(0)));
			}
			/** else if a unary operator is encountered (i.e. sqrt, sin, cos, tan, '%', '!'))
			 */
			else if(token[x].equals("%") || token[x].equals("q") || token[x].equals("!") ||
					token[x].equals("s") || token[x].equals("c") || token[x].equals("t")) {
				stack.push(evaluate(stack.pop(), 0, token[x].charAt(0)));
			}
			/** Special case: If pi constant is encountered
			 */
			else if(token[x].equals("p")) {
				stack.push(Math.PI);
			}
			/**else if a number is encountered*/
			else {
				stack.push(Double.parseDouble(token[x]));
			}
		}

		System.out.println("FINAL VALUE: " + stack.peek() + "\n");
		return "" + stack.pop();
	}

	private double evaluate(double arg2, double arg1, char operation) {
		switch(operation) {
			case '+': return arg1 + arg2;
			case '-': return arg1 - arg2;
			case '*': return arg1 * arg2;
			case '/': return arg1 / arg2;
			case '%': return arg2 * 0.01;
			case '^': return Math.pow(arg1, arg2);
			case 'q': return Math.sqrt(arg2);
			case 's': return Math.sin(arg2);
			case 'c': return Math.cos(arg2);
			case 't': return Math.tan(arg2);
			case '!':
				double result = 1;
				int x = (int) Math.floor(arg2);
				for(int y = 2; y <= x; ++y) {
					result *= y;
				}
				return result;
				
			default: return 0;
		}
	}
}