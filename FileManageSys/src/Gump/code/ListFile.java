package Gump.code;

import java.io.File;

public class ListFile {
	public static void listFile(String currPath){
		StringBuilder info = new StringBuilder();
			
		File file = new File(currPath);
		File[] fileList = file.listFiles();//获取子文件列表

		info.append("文件总数：");
		info.append(fileList.length);
		info.append("\n");
		for (File i : fileList) {
			if (!i.isHidden()) {

				if (i.isDirectory()) {//判断是否是目录
					info.append("d");
				} else {
					info.append("-");
				}

				if (i.canExecute()) {//判断是否是可执行文件
					info.append("x");
				} else {
					info.append("-");
				}

				if (i.canRead()) {//判断是否可读
					info.append("r");
				} else {
					info.append("-");
				}

				if (i.canWrite()) {//判断是否可写
					info.append("w");
				} else {
					info.append("-");
				}
				info.append("\t");

				if (i.isDirectory()) {//如果是文件夹，则获取其子文件个数
					File[] iList = i.listFiles();
					info.append(iList.length);
				} else {
					info.append(0);
				}
				info.append("\t");

				String fileSize = String.format("%10.2fkb", i.length() / 1024.0);//获取文件大小。并按格式输出
				info.append(fileSize);
				info.append("\t");
					
				info.append(i.getName());//获取文件名称
				info.append("\n");
			}
		}
		System.out.println(info.toString());
	}
}