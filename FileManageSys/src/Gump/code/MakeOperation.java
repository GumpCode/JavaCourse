package Gump.code;

import java.io.File;

public class MakeOperation {
	/**
	 * <p>
	 * 在当前文件夹创建文件
	 * <p>
	 * 
	 * @param currPath
	 * @param fileName
	 * @throws Exception
	 */
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
	

	/**
	 * <p>
	 * 在指定文件夹创建文件
	 * <p>
	 * 
	 * @param currPath
	 * @param fileName
	 * @param desPath
	 * @throws Exception
	 */
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
	
	
	/**
	 * <p>
	 * 在当前文件夹创建文件夹
	 * <p>
	 * 
	 * @param currPath
	 * @param dirName
	 * @throws Exception
	 */
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
	
	
	/**
	 * <p>
	 * 在指定文件夹创建文件夹
	 * <p>
	 * 
	 * @param currPath
	 * @param dirName
	 * @param desPath
	 * @throws Exception
	 */
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
