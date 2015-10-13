package Gump.code;

public class ManagerCenter {

	protected boolean SysOpter(String[] commandLine) throws Exception{
		SysInfo Info = new SysInfo();
		switch(commandLine[0]){
			case "cd":
				if(commandLine.length == 2){
					OpenFolder.cdFolder(Info.getPath(), commandLine[1]);
				} else {
					System.err.println(commandLine[0] +": command format is wrong!");
				}
				break;
			case "mkfile": 
				if(commandLine.length == 2){
					MakeOperation.mkFile(Info.getPath(), commandLine[1]);
				} else if(commandLine.length == 3){
					MakeOperation.mkFile(Info.getPath(), commandLine[1], commandLine[2]);
				} else {
					System.err.println(commandLine[0] +": command format is wrong!");
				}
				break;
			case "mkdir": 
				if(commandLine.length == 2){
					MakeOperation.mkDir(Info.getPath(), commandLine[1]);
				} else if(commandLine.length == 3) {
					MakeOperation.mkDir(Info.getPath(), commandLine[1], commandLine[2]);
				} else {
					System.err.println(commandLine[0] +": command format is wrong!");
				}
				break;
			case "rm": 
				if(commandLine.length == 2){
					DeleteOperation.rmOperate(Info.getPath(), commandLine[1]);
				} else {
					System.err.println(commandLine[0] +": command format is wrong!");
				}
				break;
			case "ls": 
				if(commandLine.length == 1){
					ListFile.listFile(Info.getPath());
				} else {
					System.err.println(commandLine[0] +": command format is wrong!");
				}
				break;
			case "zip": 
				if(commandLine.length == 2){
					CompressOperation.zip(Info.getPath() + "/" + commandLine[1]); 
				} else if (commandLine.length == 3){
					CompressOperation.zip(Info.getPath() + "/" + commandLine[1], commandLine[2]);
				} else {
					System.err.println(commandLine[0] +": command format is wrong!");
				}
				break;
			case "unzip": 
				if(commandLine.length == 2){
					ExtractOperation.unzip(Info.getPath() + "/" + commandLine[1]);
				} else if(commandLine.length == 3){
					ExtractOperation.unzip(Info.getPath() + "/" + commandLine[1], commandLine[2]);
				} else {
					System.err.println(commandLine[0] +": command format is wrong!");
				}
				break;
			//case "tar": CompressOperation.tarFile(commandLine[1], commandLine[2], Info.getPath()); break;
			case "cp": 
				if(commandLine.length == 3){
					CopyOperation.copy(Info.getPath(), commandLine[1], commandLine[2]);
				} else {
					System.err.println(commandLine[0] +": command format is wrong!");
				}
				break;
			case "encrypt":
				if(commandLine.length == 2){
					EncryptOperation.encryptFile(Info.getPath(), commandLine[1], " ");
				} else if(commandLine.length == 3){
					EncryptOperation.encryptFile(Info.getPath(), commandLine[1], commandLine[2]);
				} else {
					System.err.println(commandLine[0] +": command format is wrong!");
				}
				break;
			case "decrypt":
				if(commandLine.length == 3){
					DecryptOperation.decryptFile(Info.getPath(), commandLine[1], " ", commandLine[2]);
				} else if(commandLine.length == 4){
					DecryptOperation.decryptFile(Info.getPath(), commandLine[1], commandLine[2], commandLine[3]);
				} else {
					System.err.println(commandLine[0] +": command format is wrong!");
				}
				break;
			case "exit":
				System.out.println("system is exit!");
				return false; 
			case "help":
				SysInfo.HelpInfo();
				break;
			default: System.err.println(commandLine[0] + ": command not found");
				break;
		}
		return true;
	}
}
