@Test public void shouldUseConfiguredHashStrategy() throws Exception {
assertEquals(MD5HashStrategy.class,actual.getClass());
}