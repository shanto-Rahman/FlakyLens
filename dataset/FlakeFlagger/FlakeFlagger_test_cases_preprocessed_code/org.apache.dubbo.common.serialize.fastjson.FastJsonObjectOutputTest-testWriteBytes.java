@Test public void testWriteBytes() throws IOException {
assertThat(this.fastJsonObjectInput.readBytes(),is("hello".getBytes()));
}