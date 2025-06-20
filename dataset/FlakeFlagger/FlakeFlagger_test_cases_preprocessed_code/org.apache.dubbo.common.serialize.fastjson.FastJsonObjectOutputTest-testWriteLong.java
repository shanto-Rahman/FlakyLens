@Test public void testWriteLong() throws IOException {
assertThat(fastJsonObjectInput.readLong(),is(1000L));
}