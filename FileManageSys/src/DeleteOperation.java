import java.io.File;

public class DeleteOperation {
	public static void rmOperate(String currPath, String cmInput) throws Exception{
		if(!cmInput.contains("/")){//删除当前路径下文件（夹）
			currPath = currPath + "/" + cmInput;
		} else {//删除指定路径文件（夹）
			currPath = cmInput;
		}

		File dirPath = new File(currPath);
		if(dirPath.exists()){//递归删除文件（夹）
			delAllFolder(dirPath);
		} else {
			System.out.println("The target is not exist!");
		}

		if(dirPath.exists()){//检查是否成功删除指定文件（夹）
			System.out.println("Fail to delete the file!");
		} else {
			System.out.println("Delete file successfully!");
		}
	}
	
	public static void delAllFolder(File dirPath){
		if(dirPath.isFile()){
			dirPath.delete();
		} else {
			File[] files = dirPath.listFiles();
			for(File fileItems : files){
			delAllFolder(fileItems);
			}
			dirPath.delete();
		}
	}
}
