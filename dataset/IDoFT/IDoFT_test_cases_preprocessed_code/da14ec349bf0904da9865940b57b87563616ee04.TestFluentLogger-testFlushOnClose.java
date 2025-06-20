@Test public void testFlushOnClose() throws Exception {
latch.countDown();
threadManager.submit(fluentd);//IT
latch.await(3,TimeUnit.SECONDS);
threadManager.join();//IT
assertEquals(1,elist.size());
assertEquals("prefix.tag",ev.tag);
assertEquals(1,ev.data.size());
assertTrue(ev.data.containsKey("k"));
assertTrue(ev.data.containsValue("v"));
}