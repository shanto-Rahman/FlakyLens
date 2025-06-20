@Test public void test_Ex_OnInvoke() throws Exception {
Person ret=demoProxy.get(requestId);//IT
Assert.assertEquals(null,ret);
if (!notify.inv.contains(requestId)) {
Thread.sleep(200);
}
Assert.assertTrue(notify.inv.contains(requestId));
}