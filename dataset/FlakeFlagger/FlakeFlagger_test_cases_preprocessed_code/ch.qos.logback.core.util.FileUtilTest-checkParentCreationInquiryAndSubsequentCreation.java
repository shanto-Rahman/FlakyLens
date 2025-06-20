@Test public void checkParentCreationInquiryAndSubsequentCreation(){
File file=new File(CoreTestConstants.OUTPUT_DIR_PREFIX + "/fu" + diff+ "/testing.txt");//RO
assertTrue(FileUtil.isParentDirectoryCreationRequired(file));
assertTrue(FileUtil.createMissingParentDirectories(file));
assertFalse(FileUtil.isParentDirectoryCreationRequired(file));
}