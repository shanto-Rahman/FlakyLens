@Test public void test_Sync_Onreturn() throws Exception {
Person ret=demoProxy.get(requestId);//IT
Assert.assertEquals(requestId,ret.getId());//IT
if (!notify.ret.containsKey(requestId)) {
Thread.sleep(200);
}
Assert.assertEquals(requestId,notify.ret.get(requestId).getId());
}