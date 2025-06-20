@Test public void testWriteNull() throws IOException {
assertThat(writer.toString(),is("aba"));
}