@Test public void testObjectInput() throws IOException {
assertThat(objectInput,Matchers.<ObjectInput>instanceOf(FastJsonObjectInput.class));
}