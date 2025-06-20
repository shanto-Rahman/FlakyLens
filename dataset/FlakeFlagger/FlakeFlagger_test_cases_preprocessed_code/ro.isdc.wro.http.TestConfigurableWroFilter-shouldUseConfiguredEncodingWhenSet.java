@Test public void shouldUseConfiguredEncodingWhenSet() throws Exception {
assertEquals(encoding,Context.get().getConfig().getEncoding());
}