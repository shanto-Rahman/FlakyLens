@Test public void testEndpointAlreadyBoundNonFatal() throws Exception {
t.start();
Assert.assertNotNull(endpoint2.getException());
Thread.sleep(500);
Assert.assertEquals(IOReactorStatus.ACTIVE,ioreactor.getStatus());
t.join(1000);
Assert.assertEquals(IOReactorStatus.SHUT_DOWN,ioreactor.getStatus());
}