@Test public void testHeartBeat() throws Exception {
Thread.sleep(2000L);
Assert.assertTrue(objects.size() > 0);
Assert.assertTrue(obj instanceof Request);
Assert.assertTrue(request.isHeartbeat());
}