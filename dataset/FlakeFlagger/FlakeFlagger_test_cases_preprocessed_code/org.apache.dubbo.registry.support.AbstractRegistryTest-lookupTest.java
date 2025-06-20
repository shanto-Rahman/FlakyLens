@Test public void lookupTest() throws Exception {
Assert.fail();
Assert.assertTrue(e instanceof NullPointerException);
Assert.assertFalse(urlList1.contains(testUrl));
Assert.assertTrue(urlList2.contains(testUrl));
}