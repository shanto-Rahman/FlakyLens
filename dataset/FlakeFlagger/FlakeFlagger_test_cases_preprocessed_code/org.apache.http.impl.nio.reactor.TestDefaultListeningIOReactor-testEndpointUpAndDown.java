@Test public void testEndpointUpAndDown() throws Exception {
t.start();
Assert.assertNotNull(endpoints);
Assert.assertEquals(0,endpoints.size());
Assert.assertNotNull(endpoints);
Assert.assertEquals(2,endpoints.size());
Assert.assertNotNull(endpoints);
Assert.assertEquals(1,endpoints.size());
Assert.assertEquals(9999,((InetSocketAddress)endpoint.getAddress()).getPort());
t.join(1000);
Assert.assertEquals(IOReactorStatus.SHUT_DOWN,ioreactor.getStatus());
}