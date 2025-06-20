@Test public void testToStringWithCharset() throws IOException {
assertThat(outputStream.toString("UTF-8"),is("Hòa Bình"));
}