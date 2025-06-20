@Test public void testObjectOutput() throws IOException {
assertThat(objectOutput,Matchers.<ObjectOutput>instanceOf(FastJsonObjectOutput.class));
}