@Test public void test_Ex_Onthrow() throws Exception {
Person ret=demoProxy.get(requestId);//IT
Assert.assertEquals(null,ret);
if (!notify.errors.containsKey(requestId)) {
Thread.sleep(200);
}
Assert.assertTrue(notify.errors.containsKey(requestId));
Assert.assertTrue(notify.errors.get(requestId) instanceof Throwable);
}