@Test public void testWriteFloat() throws IOException {
assertThat(this.fastJsonObjectInput.readFloat(),is(1.88f));
}