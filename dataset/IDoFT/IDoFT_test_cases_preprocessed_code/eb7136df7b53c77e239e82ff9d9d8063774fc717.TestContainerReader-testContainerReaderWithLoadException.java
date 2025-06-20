@Test public void testContainerReaderWithLoadException() throws Exception {
if (i == 0) {
File containerPath=new File(containerPathStr);//RO
Assert.assertTrue(containerPath.renameTo(new File(renamePath)));//RO
}
Assert.assertEquals(containerCount - 1,containerSet1.containerCount());
}