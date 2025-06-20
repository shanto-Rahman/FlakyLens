@Test public void testReadObject() throws IOException, ClassNotFoundException {
assertThat(result,not(nullValue()));
assertThat(result.getName(),is("John"));
assertThat(result.getAge(),is(30));
}