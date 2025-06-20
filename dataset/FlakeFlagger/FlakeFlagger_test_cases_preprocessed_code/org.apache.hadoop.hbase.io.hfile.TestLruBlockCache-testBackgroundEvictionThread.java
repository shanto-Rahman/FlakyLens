public void testBackgroundEvictionThread() throws Exception {
Thread.sleep(1000);
assertTrue(n++ < 2);
assertEquals(cache.getEvictionCount(),1);
}