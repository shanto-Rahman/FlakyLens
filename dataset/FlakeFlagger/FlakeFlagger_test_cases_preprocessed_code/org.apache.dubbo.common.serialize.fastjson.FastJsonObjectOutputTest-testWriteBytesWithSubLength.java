@Test public void testWriteBytesWithSubLength() throws IOException {
assertThat(this.fastJsonObjectInput.readBytes(),is("ll".getBytes()));
}