@Test public void test_Sync_NoFuture() throws Exception {
Person ret=demoProxy.get(requestId);//IT
Assert.assertEquals(requestId,ret.getId());//IT
Assert.assertEquals(null,pFuture);
}