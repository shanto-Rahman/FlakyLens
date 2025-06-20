@Test public void testUnhandledRuntimeException() throws Exception {
if (b == null) {
}
requestConns.countDown();
requestConns.await();
Assert.assertEquals(0,requestConns.getCount());
Assert.assertNotNull(ex);
Assert.assertTrue(ex instanceof IOReactorException);
Assert.assertNotNull(ex.getCause());
Assert.assertTrue(ex.getCause() instanceof OoopsieRuntimeException);
Assert.assertNotNull(auditlog);
Assert.assertEquals(1,auditlog.size());
Assert.assertEquals(IOReactorStatus.SHUT_DOWN,this.server.getStatus());
}