@Test public void testWriteBeyondFileSize() throws Exception {
Assert.assertEquals(0,testfile.length());
Assert.fail("IOException should have been thrown");
}