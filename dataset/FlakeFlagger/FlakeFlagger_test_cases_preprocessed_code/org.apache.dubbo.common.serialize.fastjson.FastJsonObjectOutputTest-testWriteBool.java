@Test public void testWriteBool() throws IOException {
assertThat(fastJsonObjectInput.readBool(),is(true));
}