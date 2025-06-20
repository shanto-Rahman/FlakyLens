@Test public void testHttpProtocol(){
Assert.assertFalse(server.isCalled());
Assert.assertTrue(server.isCalled());
Assert.assertEquals("Hello, haha",result);
}