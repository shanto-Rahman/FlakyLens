@Test(expected=RuntimeException.class) public void test_Async_Future_Ex() throws Throwable {
Person ret=demoProxy.get(requestId);//IT
Assert.assertEquals(null,ret);
ret=pFuture.get(1000 * 1000,TimeUnit.MICROSECONDS);
Assert.assertEquals(requestId,ret.getId());//IT
}