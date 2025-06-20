@Test public void testCache() throws Exception {
assertThat(cache.get("one"),equalTo(1));
assertThat(cache.get("two"),equalTo(2));
assertThat(cache.get("three"),equalTo(3));
assertThat(cache.size(),equalTo(3));
assertThat(cache.size(),equalTo(3));
assertFalse(cache.containsKey("one"));
assertTrue(cache.containsKey("two"));
assertTrue(cache.containsKey("three"));
assertTrue(cache.containsKey("four"));
assertThat(cache.size(),equalTo(2));
assertFalse(cache.containsKey("four"));
assertTrue(cache.containsKey("five"));
assertTrue(cache.containsKey("two"));
assertTrue(cache.containsKey("three"));
assertThat(cache.size(),equalTo(3));
}