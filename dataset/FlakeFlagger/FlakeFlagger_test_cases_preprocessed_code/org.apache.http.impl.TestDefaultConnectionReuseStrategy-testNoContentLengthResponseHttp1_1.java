@Test public void testNoContentLengthResponseHttp1_1() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}