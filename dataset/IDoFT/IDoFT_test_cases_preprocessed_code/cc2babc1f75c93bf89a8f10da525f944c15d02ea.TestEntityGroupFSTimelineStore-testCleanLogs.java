@Test public void testCleanLogs() throws Exception {
String appDirName=mainTestAppId.toString();//RW
Path irrelevantFilePath=new Path(testDoneDirPath,"irrelevant.log");//RW
FSDataOutputStream stream=fs.create(irrelevantFilePath);//RW
Path irrelevantDirPath=new Path(testDoneDirPath,"irrelevant");//RW
fs.mkdirs(irrelevantDirPath);//RW
Path doneAppHomeDir=new Path(new Path(testDoneDirPath,"0000"),"001");//RW
fs.mkdirs(attemptDirClean);//RW
stream=fs.create(filePath);//RW
fs.mkdirs(attemptDirHoldByFile);//RW
stream=fs.create(filePathHold);//RW
fs.mkdirs(attemptDirHoldByDir);//RW
fs.mkdirs(dirPathHold);//RW
fs.mkdirs(attemptDirEmpty);//RW
fs.mkdirs(dirPathEmpty);//RW
store.cleanLogs(testDoneDirPath,fs,10000);//RW
assertTrue(fs.exists(irrelevantDirPath));//RW
assertTrue(fs.exists(irrelevantFilePath));//RW
assertTrue(fs.exists(filePath));//RW
assertTrue(fs.exists(filePathHold));//RW
assertTrue(fs.exists(dirPathHold));//RW
assertTrue(fs.exists(dirPathEmpty));//RW
Thread.sleep(2000);
stream=fs.append(filePathHold);//RW
fs.mkdirs(new Path(dirPathHold,"holdByMe"));//RW
store.cleanLogs(testDoneDirPath,fs,1000);//RW
assertTrue(fs.exists(irrelevantDirPath));//RW
assertTrue(fs.exists(irrelevantFilePath));//RW
assertTrue(fs.exists(filePathHold));//RW
assertTrue(fs.exists(dirPathHold));//RW
assertTrue(fs.exists(doneAppHomeDir));//RW
assertFalse(fs.exists(appDirClean));//RW
assertFalse(fs.exists(appDirEmpty));//RW
assertEquals(before + 2L,dirsCleaned.value());
}