@Test public void testRandomLoadBalanceSelect(){
Assert.assertTrue("abs diff should < avg",Math.abs(count - runs / (0f + invokers.size())) < runs / (0f + invokers.size()));
Assert.assertEquals(runs,counter.get(invoker1).intValue());
Assert.assertEquals(0,counter.get(invoker2).intValue());
Assert.assertEquals(0,counter.get(invoker3).intValue());
Assert.assertEquals(0,counter.get(invoker4).intValue());
Assert.assertEquals(0,counter.get(invoker5).intValue());
}