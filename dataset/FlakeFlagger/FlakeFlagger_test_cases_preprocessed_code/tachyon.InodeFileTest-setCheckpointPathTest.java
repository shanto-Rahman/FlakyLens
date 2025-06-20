@Test public void setCheckpointPathTest(){
Assert.assertFalse(inodeFile.hasCheckpointed());
Assert.assertEquals("",inodeFile.getCheckpointPath());
Assert.assertEquals("/testPath",inodeFile.getCheckpointPath());
}