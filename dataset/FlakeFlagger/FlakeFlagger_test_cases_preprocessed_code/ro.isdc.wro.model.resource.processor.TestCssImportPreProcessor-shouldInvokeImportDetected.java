@Test public void shouldInvokeImportDetected() throws IOException {
times.incrementAndGet();
assertEquals(1,times.get());
}