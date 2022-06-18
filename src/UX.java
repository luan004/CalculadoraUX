import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UX {

	Adicao adicao = new Adicao();
	Subtracao subtracao = new Subtracao();
	Divisao divisao = new Divisao();
	Multiplicacao mult = new Multiplicacao();
	Raiz raiz = new Raiz();

	private double v1;
	private double v2 = 1;

	public void ux() {
		JFrame frame = new JFrame();

		JTextField visor = new JTextField();
		visor.setEditable(false);
		Font font = new Font(visor.getFont().getName(), visor.getFont().getStyle(), 19);
		visor.setFont(font);

		Box vBox = Box.createVerticalBox();
		vBox.add(visor);
		vBox.add(fileira5(visor));
		vBox.add(fileira4(visor));
		vBox.add(fileira3(visor));
		vBox.add(fileira2(visor));
		vBox.add(fileira1(visor));

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(vBox);
		frame.setSize(230, 240);
		//frame.setResizable(false);
		frame.setVisible(true);
	}

	private Box fileira1(JTextField visor) {

		JButton b1 = new JButton("0");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "0");
			}
		});

		JButton b2 = new JButton(",");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] v = visor.getText().toCharArray();

				if (v.length != 0) {

					String[] valores = null;

					if (visor.getText().contains("+")) {
						valores = visor.getText().split("\\+", 2);
					} else if (visor.getText().contains("-")) {
						valores = visor.getText().split("\\-", 2);
					} else if (visor.getText().contains("*")) {
						valores = visor.getText().split("\\*", 2);
					} else if (visor.getText().contains("/")) {
						valores = visor.getText().split("\\/", 2);
					}

					if (valores == null && visor.getText().contains(",") == false) {
						visor.setText(visor.getText() + ",");
					} else if (valores != null && valores[1].contains(",") == false && valores[1].length() > 0) {
						visor.setText(visor.getText() + ",");
					}
				}
			}
		});

		JButton b3 = new JButton("=");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (visor.getText().contains("+")) {

					String[] valores = visor.getText().split("\\+", 2);

					setV1(Double.parseDouble(valores[0].replace(',', '.')));
					setV2(Double.parseDouble(valores[1].replace(',', '.')));

					visor.setText(Double.toString(adicao.a(getV1(), getV2())).replace('.', ','));

				} else if (visor.getText().contains("-")) {
					String[] valores = visor.getText().split("\\-", 2);

					setV1(Double.parseDouble(valores[0].replace(',', '.')));
					setV2(Double.parseDouble(valores[1].replace(',', '.')));

					visor.setText(Double.toString(subtracao.a(getV1(), getV2())).replace('.', ','));
				} else if (visor.getText().contains("*")) {
					String[] valores = visor.getText().split("\\*", 2);

					setV1(Double.parseDouble(valores[0].replace(',', '.')));
					setV2(Double.parseDouble(valores[1].replace(',', '.')));

					visor.setText(Double.toString(mult.a(getV1(), getV2())).replace('.', ','));
				} else if (visor.getText().contains("/")) {
					String[] valores = visor.getText().split("\\/", 2);

					setV1(Double.parseDouble(valores[0].replace(',', '.')));
					setV2(Double.parseDouble(valores[1].replace(',', '.')));

					visor.setText(Double.toString(divisao.a(getV1(), getV2())).replace('.', ','));
				}

			}
		});

		JButton b4 = new JButton("+");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char[] v = visor.getText().toCharArray();

				if (v.length != 0) {
					if (visor.getText().contains("+") || visor.getText().contains("-") || visor.getText().contains("/")
							|| visor.getText().contains("*")) {

					} else {
						visor.setText(visor.getText() + "+");
					}
				}
			}
		});

		Box f1 = Box.createHorizontalBox();
		f1.add(b1);
		f1.add(b2);
		f1.add(b3);
		f1.add(b4);

		return f1;
	}

	private Box fileira2(JTextField visor) {
		JButton b1 = new JButton("1");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "1");
			}
		});

		JButton b2 = new JButton("2");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "2");
			}
		});

		JButton b3 = new JButton("3");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "3");
			}
		});

		JButton b4 = new JButton("-");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] v = visor.getText().toCharArray();

				if (v.length != 0) {
					if (visor.getText().contains("+") || visor.getText().contains("-") || visor.getText().contains("/")
							|| visor.getText().contains("*")) {

					} else {
						setV1(Double.parseDouble(visor.getText()));
						visor.setText(visor.getText() + "-");
					}
				}
			}
		});

		Box f2 = Box.createHorizontalBox();
		f2.add(b1);
		f2.add(b2);
		f2.add(b3);
		f2.add(b4);
		return f2;
	}

	private Box fileira3(JTextField visor) {
		JButton b1 = new JButton("4");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "4");
			}
		});

		JButton b2 = new JButton("5");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "5");
			}
		});

		JButton b3 = new JButton("6");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "6");
			}
		});

		JButton b4 = new JButton("*");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] v = visor.getText().toCharArray();

				if (v.length != 0) {
					if (visor.getText().contains("+") || visor.getText().contains("-") || visor.getText().contains("/")
							|| visor.getText().contains("*")) {

					} else {
						setV1(Double.parseDouble(visor.getText()));
						visor.setText(visor.getText() + "*");
					}
				}
			}
		});

		Box f3 = Box.createHorizontalBox();
		f3.add(b1);
		f3.add(b2);
		f3.add(b3);
		f3.add(b4);
		return f3;
	}

	private Box fileira4(JTextField visor) {
		JButton b1 = new JButton("7");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "7");
			}
		});

		JButton b2 = new JButton("8");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "8");
			}
		});

		JButton b3 = new JButton("9");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + "9");
			}
		});

		JButton b4 = new JButton("/");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] v = visor.getText().toCharArray();

				if (v.length != 0) {
					if (visor.getText().contains("+") || visor.getText().contains("-") || visor.getText().contains("/")
							|| visor.getText().contains("*")) {

					} else {
						setV1(Double.parseDouble(visor.getText()));
						visor.setText(visor.getText() + "/");
					}
				}
			}
		});

		Box f4 = Box.createHorizontalBox();
		f4.add(b1);
		f4.add(b2);
		f4.add(b3);
		f4.add(b4);
		return f4;
	}

	private Box fileira5(JTextField visor) {
		JButton b1 = new JButton("π");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(visor.getText() + Math.PI);
			}
		});

		JButton b2 = new JButton("tab");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (visor.getText().isEmpty() == false) {
					if (visor.getText().contains("+") == false|| visor.getText().contains("-") == false|| visor.getText().contains("*") == false|| visor.getText().contains("/")== false) {
						
						
						try {
							gerarTabuada(Double.parseDouble(visor.getText().replace(",", ".")));
						}
						catch (NumberFormatException nexc){
							System.out.println("Não é possível calcular isso");
							
						}
					}
				}

			}
		});

		JButton b3 = new JButton("√");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visor.setText(Double.toString(raiz.a(Double.parseDouble(visor.getText()))));
			}
		});

		JButton b4 = new JButton("⌫");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char[] v = visor.getText().toCharArray();
				
				if (v.length > 0) {
					v[v.length - 1] = 'C';
					visor.setText(String.valueOf(v).replaceAll("C", ""));
				}
				
			}
		});

		Box f5 = Box.createHorizontalBox();
		f5.add(b1);
		f5.add(b2);
		f5.add(b3);
		f5.add(b4);
		return f5;
	}

	protected void gerarTabuada(double d) {
		
		JLabel t1 = new JLabel(); t1.setText(Double.toString(d) + " * 1 = " + Double.toString(d*1));
		JLabel t2 = new JLabel(); t2.setText(Double.toString(d) + " * 2 = " + Double.toString(d*2));
		JLabel t3 = new JLabel(); t3.setText(Double.toString(d) + " * 3 = " + Double.toString(d*3));
		JLabel t4 = new JLabel(); t4.setText(Double.toString(d) + " * 4 = " + Double.toString(d*4));
		JLabel t5 = new JLabel(); t5.setText(Double.toString(d) + " * 5 = " + Double.toString(d*5));
		JLabel t6 = new JLabel(); t6.setText(Double.toString(d) + " * 6 = " + Double.toString(d*6));
		JLabel t7 = new JLabel(); t7.setText(Double.toString(d) + " * 7 = " + Double.toString(d*7));
		JLabel t8 = new JLabel(); t8.setText(Double.toString(d) + " * 8 = " + Double.toString(d*8));
		JLabel t9 = new JLabel(); t9.setText(Double.toString(d) + " * 9 = " + Double.toString(d*9));
		JLabel t10 = new JLabel();t10.setText(Double.toString(d) + " * 10 = " + Double.toString(d*10));
		
		JFrame frame = new JFrame();
		
		Box vBox = Box.createVerticalBox();
		vBox.add(t1);
		vBox.add(t2);
		vBox.add(t3);
		vBox.add(t4);
		vBox.add(t5);
		vBox.add(t6);
		vBox.add(t7);
		vBox.add(t8);
		vBox.add(t9);
		vBox.add(t10);
		
		
		frame.add(vBox);
		frame.setSize(110, 200);
		frame.setVisible(true);
		
	}

	public double getV1() {
		return v1;
	}

	public void setV1(double v1) {
		this.v1 = v1;
	}

	public double getV2() {
		return v2;
	}

	public void setV2(double v2) {
		this.v2 = v2;
	}

}
