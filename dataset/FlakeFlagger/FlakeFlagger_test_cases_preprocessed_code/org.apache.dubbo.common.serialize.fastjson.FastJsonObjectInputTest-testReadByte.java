@Test public void testReadByte() throws IOException {
assertThat(result,is(Byte.parseByte("123")));
}