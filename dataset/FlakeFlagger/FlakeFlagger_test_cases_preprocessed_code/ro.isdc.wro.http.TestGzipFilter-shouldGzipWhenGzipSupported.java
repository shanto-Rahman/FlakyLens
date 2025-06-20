@Test public void shouldGzipWhenGzipSupported() throws Exception {
assertEquals(content,IOUtils.toString(ungzippedStream));
}