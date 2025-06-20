@Test public void shouldUseDefaultEncodingWhenNoEncodingIsSet() throws Exception {
assertEquals(WroConfiguration.DEFAULT_ENCODING,Context.get().getConfig().getEncoding());
}