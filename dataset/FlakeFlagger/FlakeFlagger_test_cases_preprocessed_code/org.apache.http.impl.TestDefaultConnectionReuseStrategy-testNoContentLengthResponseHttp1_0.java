@Test public void testNoContentLengthResponseHttp1_0() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}