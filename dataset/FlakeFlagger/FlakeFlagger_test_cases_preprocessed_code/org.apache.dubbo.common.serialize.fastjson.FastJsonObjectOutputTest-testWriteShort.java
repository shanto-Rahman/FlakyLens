@Test public void testWriteShort() throws IOException {
assertThat(fastJsonObjectInput.readShort(),is((short)2));
}