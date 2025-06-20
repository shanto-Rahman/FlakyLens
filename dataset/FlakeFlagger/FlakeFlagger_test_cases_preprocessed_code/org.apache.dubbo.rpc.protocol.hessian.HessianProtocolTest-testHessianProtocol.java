@Test public void testHessianProtocol(){
Assert.assertFalse(server.isCalled());
Assert.assertTrue(server.isCalled());
Assert.assertEquals("Hello, haha",result);
}