@Test public void testRuntimeException() throws Exception {
if (b == null) {
}
Assert.assertNotNull(ex);
Assert.assertTrue(ex instanceof IOReactorException);
Assert.assertNotNull(ex.getCause());
Assert.assertTrue(ex.getCause() instanceof OoopsieRuntimeException);
Assert.assertNotNull(auditlog);
Assert.assertEquals(1,auditlog.size());
Assert.assertEquals(IOReactorStatus.SHUT_DOWN,this.server.getStatus());
}