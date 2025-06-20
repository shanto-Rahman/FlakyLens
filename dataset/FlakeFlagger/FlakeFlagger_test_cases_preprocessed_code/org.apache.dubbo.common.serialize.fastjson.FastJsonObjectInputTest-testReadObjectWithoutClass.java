@Test public void testReadObjectWithoutClass() throws IOException, ClassNotFoundException {
assertThat(readObject,not(nullValue()));
assertThat(readObject.getString("name"),is("John"));
assertThat(readObject.getInteger("age"),is(30));
}