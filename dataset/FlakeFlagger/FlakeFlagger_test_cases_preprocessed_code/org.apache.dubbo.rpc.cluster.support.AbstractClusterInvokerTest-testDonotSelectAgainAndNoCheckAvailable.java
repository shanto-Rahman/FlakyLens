@Test public void testDonotSelectAgainAndNoCheckAvailable(){
Assert.assertSame(invoker1,sinvoker);
Assert.assertSame(invoker2,sinvoker);
Assert.assertSame(invoker3,sinvoker);
Assert.assertSame(invoker5,sinvoker);
Assert.assertTrue(invokers.contains(sinvoker));
}