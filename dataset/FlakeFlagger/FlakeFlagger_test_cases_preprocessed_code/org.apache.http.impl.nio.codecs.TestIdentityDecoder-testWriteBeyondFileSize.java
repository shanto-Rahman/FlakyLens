@Test public void testWriteBeyondFileSize() throws Exception {
Assert.assertEquals(0,testfile.length());
Assert.fail("expected IOException");
}