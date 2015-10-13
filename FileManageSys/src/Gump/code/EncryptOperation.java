package Gump.code;

public class EncryptOperation{
    /**
     * <p>
     * 文件加密
     * </p>
     *
     * @param key
     * @param sourceFilePath
     * @param destFilePath
     * @throws Exception
     */
    public static void encryptFile(String currPath, String cmInput1, String cmInput2) throws Exception {
    	String sourceFilePath;
    	String destFilePath;
    	String key;
    	if(!cmInput1.contains("/")){
    		sourceFilePath = currPath + "/" + cmInput1;
    	} else {
    		sourceFilePath = cmInput1;
    	}
    	
    	if(cmInput2 == " "){
    		destFilePath = currPath + "/" + cmInput1;
    	} else {
    		destFilePath = cmInput2 + "/" + cmInput1;
    	}
    	key = AESUtils.encryptFile(sourceFilePath, destFilePath);
        System.out.println(key);
    }
    
}