@Test public void testSimpleClient(){
Assert.assertFalse(server.isCalled());
Assert.assertTrue(server.isCalled());
Assert.assertEquals("Hello, haha",result);
}