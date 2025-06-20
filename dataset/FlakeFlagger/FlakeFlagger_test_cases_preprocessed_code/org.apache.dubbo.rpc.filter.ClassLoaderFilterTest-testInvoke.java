@Test public void testInvoke() throws Exception {
Assert.assertEquals(cl,Thread.currentThread().getContextClassLoader());
}