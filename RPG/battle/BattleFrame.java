package battle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BattleFrame extends JFrame{
    private JPanel messagePanel;
    private JPanel imagePanel;
    private JPanel buttonPanel;
    private JPanel commandPanel;
    private JPanel p;
    private ImageIcon icon;
    private JLabel imageLabel;
    private JLabel messageLabel;
    private JTextArea textArea;

    public BattleFrame(ActionListener al){
	super("戦闘");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(450, 550);

	GridBagConstraints gbc = new GridBagConstraints();
	GridBagLayout layout = new GridBagLayout();
	// 主たるパネルの生成
	p = new JPanel();
	p.setLayout(layout);

	// メッセージパネル
	messagePanel = new JPanel();
	messageLabel = new JLabel();
	messagePanel.add(messageLabel, BorderLayout.CENTER);
	
	// イメージパネル
	imagePanel = new JPanel();
	icon = new ImageIcon();
	imageLabel = new JLabel();
	imagePanel.add(imageLabel, BorderLayout.CENTER);

	// ボタンパネル
	buttonPanel = new JPanel(new GridLayout(1, 4));
	// 攻撃用ボタンの生成とリスナーへの追加
	JButton attack = new JButton("攻撃");
	attack.addActionListener(al);
	attack.setActionCommand("Attack");
	// 魔法(敵)用ボタンの生成とリスナーへの追加
	JButton magicEnemy = new JButton("敵に魔法");
	magicEnemy.addActionListener(al);
	magicEnemy.setActionCommand("MagicEnemy");
	// 魔法(自分)用ボタンの生成とリスナーへの追加
	JButton magicSelf = new JButton("自分に魔法");
	magicSelf.addActionListener(al);
	magicSelf.setActionCommand("MagicSelf");
	// 逃げる用ボタンの生成とリスナーへの追加
	JButton escape = new JButton("逃げる");
	escape.addActionListener(al);
	escape.setActionCommand("Escape");
	// ボタン用パネルへのコマンドボタンの追加
	buttonPanel.add(attack);
	buttonPanel.add(magicEnemy);
	buttonPanel.add(magicSelf);
	buttonPanel.add(escape);

	// コマンドパネル
	commandPanel = new JPanel();
	textArea = new JTextArea();
	textArea.setLineWrap(true);
	JScrollPane scrollpane = new JScrollPane(textArea);
	scrollpane.setPreferredSize(new Dimension(300, 100));
	commandPanel.add(scrollpane);
	
	// 各パネルの配置
	gbc.gridx = 0; gbc.gridy = 0;
	layout.setConstraints(messagePanel, gbc);
	gbc.gridx = 0; gbc.gridy = 1;
	layout.setConstraints(imagePanel,   gbc);
	gbc.gridx = 0; gbc.gridy = 2;
	layout.setConstraints(buttonPanel,  gbc);
	gbc.gridx = 0; gbc.gridy = 3;
	layout.setConstraints(commandPanel, gbc);

        // 各パネルの追加と主たるパネルへの中央配置
	p.add(messagePanel);
	p.add(imagePanel);
	p.add(buttonPanel);
	p.add(commandPanel);
	getContentPane().add(p, BorderLayout.CENTER);

	setVisible(true);
    }

    public void setMessageText(String str){
	messageLabel.setText(str);
    }

    public void setCommandText(String str){
	textArea.append(str);
    }

    public void setImage(Image image){
	icon = new ImageIcon(image);
	imageLabel.setIcon(icon);
    }
}
