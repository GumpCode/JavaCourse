package Gump.code;

import java.util.Scanner;

public class CommandLine {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		boolean flag = true;
		ManagerCenter SystemCenter = new ManagerCenter();

		//打印欢迎帮助界面
		SysInfo.HelpInfo();
		Scanner br = new Scanner(System.in);
		System.out.print("\n" + "Are we start?(Y/N):");
		String input = br.nextLine();
		if(input.equals("Y") || input.equals("y")){//进入系统
			SysInfo Info = new SysInfo();
			Info.getSysInfo();
			while(flag){
				System.out.print(Info.showInfo());
				String[] commandLine = br.nextLine().trim().split(" ");
				flag = SystemCenter.SysOpter(commandLine);
			}
		} else if(input.equals("N") || input.equals("n")){ //退出系统
			System.out.println("System is exit!");
		} else { // 输入错误，系统退出
			System.out.println("Input error, System is exit!");
		}
		br.close();
	}
}
