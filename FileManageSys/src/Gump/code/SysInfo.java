package Gump.code;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SysInfo {
	public static void HelpInfo(){
		String str = "---------------Help Info---------------------";
		System.out.print(str+"\n");
		System.out.print("进入文件夹:"+"\n"+
			"\tcd [FilePath]"+"\n"+
			"创建文件:"+"\n"+
			"\tmkfile [FileName]"+"\n"+
			"\tmkfile [FileName] [destPath]"+"\n"+
		    "创建文件夹:"+"\n"+
		    "\tmkdir [DirName]"+"\n"+
		    "\tmkdir [DirName] [destPath]"+"\n"+
			"删除文件:"+"\n"+
			"\trm [TargetName]"+"\n"+
			"\trm [Path+TargetName]"+"\n"+
			"罗列文件夹:"+"\n"+
			"\tls"+"\n"+
			"文件(夹)zip压缩:"+"\n"+
			"\tzip [FileName] "+"\n"+
			"\tzip [FileName] [PlacePath+ComprName+.zip]"+"\n"+
			//"文件(夹)tar压缩:tar [FileName] [PlacePath]"+"\n"+
			"文件(夹)unzip解压:"+"\n"+
			"\tunzip [FileName] [PlacePath]"+"\n"+
			//"文件(夹)untar解压:untar [FileName] [PlacePath]"+"\n"+
			"文件(夹)拷贝:"+"\n"+
			"\tcp [oldFilePath] [newFilePath]"+"\n"+
			"文件(夹)加密:"+"\n"+
			"\tencrypt [FileName]"+"\n"+
			"\tencrypt [FileName] [destPath]"+"\n"+
			"文件(夹)解密:"+"\n"+
			"\tdecrypt [FileName]"+"\n"+
			"\tdecrypt [FileName] [destPath]"+"\n"+
			"退出系统：exit"+"\n"
		);
	}

	private static String computerName = null;
	private static String userName = null;
	private  static String path = null;
	
	public void getSysInfo(){
		InetAddress i;
		try {
			i = InetAddress.getLocalHost();
			computerName = i.getHostName();//获取主机名
			userName = System.getProperty("user.name");//获取用户名
			path = System.getProperty("user.home");//获取系统用户根目录
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public String getPath(){
		return path;
	}
	
	public static void setPath(String newPath){
		path = newPath;
	}
	
	public String showInfo() {
		return userName + "@" + computerName + ":" + path + "$ ";
		//return computerName + ":" + path + "$ ";
	}
}
