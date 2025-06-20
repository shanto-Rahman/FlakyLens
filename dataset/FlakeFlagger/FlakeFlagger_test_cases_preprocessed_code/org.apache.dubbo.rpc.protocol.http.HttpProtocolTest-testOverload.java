@Test public void testOverload(){
Assert.assertFalse(server.isCalled());
Assert.assertEquals("Hello, haha",result);
Assert.assertEquals("Hello, haha. ",result);
}