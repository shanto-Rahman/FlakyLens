@Test public void testCapacity() throws Exception {
assertThat(cache.getMaxCapacity(),equalTo(1000));
assertThat(cache.getMaxCapacity(),equalTo(10));
}