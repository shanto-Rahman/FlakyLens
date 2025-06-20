@Test public void filterEmptyTest() throws Exception {
Assert.fail();
Assert.assertTrue(e instanceof NullPointerException);
Assert.fail();
Assert.assertTrue(e instanceof NullPointerException);
Assert.assertEquals(AbstractRegistry.filterEmpty(testUrl,null),urls);
Assert.assertEquals(AbstractRegistry.filterEmpty(testUrl,testUrls),urls);
Assert.assertEquals(AbstractRegistry.filterEmpty(testUrl,testUrls),testUrls);
}