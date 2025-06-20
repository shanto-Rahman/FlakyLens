@Test public void EmptyImageTest() throws Exception {
Assert.assertEquals(1,info.ls("/",true).size());
Assert.assertTrue(info.getFileId("/") != -1);
}