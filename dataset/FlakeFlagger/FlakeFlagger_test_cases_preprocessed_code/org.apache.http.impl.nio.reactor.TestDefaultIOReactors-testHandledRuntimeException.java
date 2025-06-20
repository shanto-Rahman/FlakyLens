@Test public void testHandledRuntimeException() throws Exception {
if (b == null) {
}
requestConns.countDown();
requestConns.await();
Assert.assertEquals(0,requestConns.getCount());
Assert.assertEquals(IOReactorStatus.ACTIVE,this.server.getStatus());
Assert.assertNull(this.server.getException());
}