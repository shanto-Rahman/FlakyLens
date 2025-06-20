@Test public void test_Async_Future_Multi() throws Exception {
Person ret=demoProxy.get(requestId1);//IT
Assert.assertEquals(null,ret);
Person ret2=demoProxy.get(requestId2);//IT
Assert.assertEquals(null,ret2);
ret=p1Future.get(1000 * 1000,TimeUnit.MICROSECONDS);
ret2=p2Future.get(1000 * 1000,TimeUnit.MICROSECONDS);
Assert.assertEquals(requestId1,ret.getId());//IT
Assert.assertEquals(requestId2,ret.getId());//IT
}