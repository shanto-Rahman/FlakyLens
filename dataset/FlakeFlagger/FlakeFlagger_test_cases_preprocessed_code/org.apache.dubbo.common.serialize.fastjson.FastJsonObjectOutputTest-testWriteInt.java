@Test public void testWriteInt() throws IOException {
assertThat(fastJsonObjectInput.readInt(),is(1));
}