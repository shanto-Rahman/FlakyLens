@Test public void testAddress(){
Assert.assertTrue(context.getLocalAddress().getPort() == 20880);
Assert.assertEquals("127.0.0.1:20880",context.getLocalAddressString());
Assert.assertTrue(context.getRemoteAddress().getPort() == 20880);
Assert.assertEquals("127.0.0.1:20880",context.getRemoteAddressString());
Assert.assertTrue(context.getRemoteAddress().getPort() == 0);
Assert.assertTrue(context.getLocalAddress().getPort() == 0);
Assert.assertEquals("127.0.0.1",context.getRemoteHostName());
Assert.assertEquals("127.0.0.1",context.getLocalHostName());
}