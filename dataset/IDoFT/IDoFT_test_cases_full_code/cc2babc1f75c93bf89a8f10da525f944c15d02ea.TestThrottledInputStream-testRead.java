@Test public void testRead(){
  File tmpFile;
  File outFile;
  try {
    tmpFile=createFile(1024);
    outFile=createFile();
    tmpFile.deleteOnExit();
    outFile.deleteOnExit();
    long maxBandwidth=copyAndAssert(tmpFile,outFile,0,1,-1,CB.BUFFER);
    copyAndAssert(tmpFile,outFile,maxBandwidth,20,0,CB.BUFFER);
    copyAndAssert(tmpFile,outFile,maxBandwidth,20,0,CB.BUFF_OFFSET);
    copyAndAssert(tmpFile,outFile,maxBandwidth,20,0,CB.ONE_C);
  }
 catch (  IOException e) {
    LOG.error("Exception encountered ",e);
  }
}
