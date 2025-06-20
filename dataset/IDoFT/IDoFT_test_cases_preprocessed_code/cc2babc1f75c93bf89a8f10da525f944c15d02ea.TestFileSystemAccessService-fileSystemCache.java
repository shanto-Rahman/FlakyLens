@Test @TestDir @TestHdfs public void fileSystemCache() throws Exception {
Assert.assertNotNull(fs1);
Assert.assertEquals(fs1,fs2);
Thread.sleep(4 * 1000);
Thread.sleep(4 * 1000);
Thread.sleep(4 * 1000);
Assert.fail();
Assert.fail();
}