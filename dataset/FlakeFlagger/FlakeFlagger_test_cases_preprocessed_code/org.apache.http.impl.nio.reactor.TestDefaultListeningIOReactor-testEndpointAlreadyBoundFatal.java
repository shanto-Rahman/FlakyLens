@Test public void testEndpointAlreadyBoundFatal() throws Exception {
Assert.fail("IOException should have been thrown");
latch.countDown();
t.start();
Assert.assertNotNull(endpoint2.getException());
latch.await(2000,TimeUnit.MILLISECONDS);
Assert.assertTrue(ioreactor.getStatus().compareTo(IOReactorStatus.SHUTTING_DOWN) >= 0);
Assert.assertNotNull(endpoints);
Assert.assertEquals(0,endpoints.size());
t.join(1000);
Assert.assertEquals(IOReactorStatus.SHUT_DOWN,ioreactor.getStatus());
}