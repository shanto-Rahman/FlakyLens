@Test public void filesOnSameFolderShouldBeOnTheSameFileStore() throws RolloverFailure, IOException {
if (!EnvUtil.isJDK7OrHigher()) return;
File parent=new File(pathPrefix);//RO
File file=new File(pathPrefix + "filesOnSameFolderShouldBeOnTheSameFileStore");//RO
assertTrue(FileStoreUtil.areOnSameFileStore(parent,file));
}