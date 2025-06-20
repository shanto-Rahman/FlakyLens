private void testCache(String type) throws Exception {
assertTrue(fix == null || fix.equals(result));
Thread.sleep(100);
if ("lru".equals(type)) {
assertTrue(pre == null || pre.equals(result));
assertFalse(fix == null || fix.equals(result));
}
}