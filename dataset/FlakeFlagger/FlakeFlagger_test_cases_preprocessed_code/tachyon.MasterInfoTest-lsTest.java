@Test public void lsTest() throws FileAlreadyExistException, InvalidPathException, TachyonException, BlockInfoException, FileDoesNotExistException {
Assert.assertEquals(1,mMasterInfo.ls("/i0/j0",false).size());
Assert.assertEquals(1,mMasterInfo.ls("/i0/j0",true).size());
Assert.assertEquals(11,mMasterInfo.ls("/i" + i,false).size());
Assert.assertEquals(11,mMasterInfo.ls("/i" + i,true).size());
Assert.assertEquals(11,mMasterInfo.ls("/",false).size());
Assert.assertEquals(111,mMasterInfo.ls("/",true).size());
}