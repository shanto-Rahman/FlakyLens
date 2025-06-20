@Test public void testInvokeWithException() throws Exception {
Assert.assertEquals(RuntimeException.class,result.getException().getClass());
}