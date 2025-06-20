@Test public void testWriteByte() throws IOException {
assertThat(this.fastJsonObjectInput.readByte(),is((byte)123));
}