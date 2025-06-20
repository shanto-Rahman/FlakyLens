@Test public void testDeserialize() throws IOException {
assertThat(objectInput,Matchers.<ObjectInput>instanceOf(FstObjectInput.class));
}