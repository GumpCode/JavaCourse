import java.io.File;

public class OpenFolder {
	public static void cdFolder(String currPath, String cmPath){
		/*
		 * 分四种情况考虑：
		 * cd . 打开根目录
		 * cd .. 打开上一层目录
		 * cd [diretory in this path] 打开当前目录文件夹
		 * cd [diretory in other path] 打开指定路径
		 */

		String PathTemp = "";
		if(cmPath.equals("..")){ //打开上一层目录
			if(!(currPath.equals("/"))){
				currPath = currPath.substring(0, currPath.lastIndexOf("/"));
			}
		} else if(cmPath.equals(".")){ //打开根目录
			currPath = "/";
		} else if(!cmPath.contains("/")){ //打开当前目录文件夹
			PathTemp = currPath + "/" + cmPath;
			File file = new File(PathTemp);
			if(file.isDirectory()){
				currPath = PathTemp;
			} else if ((!file.isDirectory() && file.exists())){
				System.out.println(cmPath + " is not a diretory!");
			} else {
				System.out.println("the file is not exist!");
			}
		} else{ //打开指定路径
			File file = new File(cmPath);
			if(file.isDirectory()){
				currPath = cmPath;
			} else if ((!file.isDirectory() && file.exists())){
				System.out.println(file + " is not a diretory!");
			} else {
				System.out.println("the file is not exist!");
			}
		}
		SysInfo.setPath(currPath);
	}
}
