@Test public void testWriteDouble() throws IOException {
assertThat(this.fastJsonObjectInput.readDouble(),is(1.66d));
}