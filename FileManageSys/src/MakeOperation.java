import java.io.File;

public class MakeOperation {
	/*
	 * 创建文件 mkfile
	 * 创建文件夹 mkdir
	 * param: currPath （程序默认输入）当前路径
	 * 		  fileName  文件名字
	 *		  despath 目标路径  
	 */

	//在当前路径建立文件
	public static void mkFile(String currPath, String fileName) throws Exception{
		currPath = currPath + "/" + fileName;
		File filePath = new File(currPath);
		if(!filePath.exists()){
			if(filePath.createNewFile()){
				System.out.println("create file succeessfully");
			} else {
				System.out.println("fail to create file!");
			}
		} else{
			System.out.println("fail to create file, this file is exist!");
		}
	}
	

	//在指定路径创建文件
	public static void mkFile(String currPath, String fileName, String desPath) throws Exception{
		desPath = desPath + "/" + fileName;
		File filePath = new File(desPath);
		if(!filePath.exists()){
			if(filePath.createNewFile()){
				System.out.println("create file succeessfully");
			} else {
				System.out.println("fail to create file!");
			}
		} else{
			System.out.println("fail to create file, this file is exist!");
		}
	}
	
	
	//在当前路径创建文件夹
	public static void mkDir(String currPath, String dirName) throws Exception{
		currPath = currPath + "/" + dirName;
		File dirPath = new File(currPath);
		if(!dirPath.exists()){
			if(dirPath.mkdirs()){
				System.out.println("create folder successfully!");
			} else {
				System.out.println("fail to create folder!");
			}
		} else {
			System.out.println("fail to create folder, this folder is exist!");
		}
	}
	
	
	//在指定路径创建文件夹
	public static void mkDir(String currPath, String dirName, String desPath) throws Exception{
		desPath = desPath + "/" + dirName;
		File dirPath = new File(desPath);
		if(!dirPath.exists()){
			if(dirPath.mkdirs()){
				System.out.println("create folder successfully!");
			} else {
				System.out.println("fail to create folder!");
			}
		} else {
			System.out.println("fail to create folder, this folder is exist!");
		}
	}
}
