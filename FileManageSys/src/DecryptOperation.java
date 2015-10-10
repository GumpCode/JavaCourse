public class DecryptOperation {
    /**
     * <p>
     * 文件解密
     * </p>
     *
     * @param key
     * @param sourceFilePath
     * @param destFilePath
     * @throws Exception
     */
    public static void decryptFile(String currPath, String cmInput1, String cmInput2, String key) throws Exception {
    	String sourceFilePath;
    	String destFilePath;
    	if(!cmInput1.contains("/")){
    		sourceFilePath = currPath + "/" + cmInput1;
    	} else {
    		sourceFilePath = cmInput1;
    	}
    	
    	if(cmInput2 == " "){
    		destFilePath = cmInput1;
    	} else {
    		String[] temp = cmInput1.split("/");
    		destFilePath = cmInput2 + "/" + temp[temp.length-1];
    	}
    	AESUtils.decryptFile(key, sourceFilePath, destFilePath);
    }
}
