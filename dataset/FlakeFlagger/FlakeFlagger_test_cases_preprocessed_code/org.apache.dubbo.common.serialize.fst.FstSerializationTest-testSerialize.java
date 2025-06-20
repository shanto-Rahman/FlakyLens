@Test public void testSerialize() throws IOException {
assertThat(objectOutput,Matchers.<ObjectOutput>instanceOf(FstObjectOutput.class));
}