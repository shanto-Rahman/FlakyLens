@Test public void testWriteObject() throws IOException, ClassNotFoundException {
assertThat(readObjectForImage,not(nullValue()));
assertThat(readObjectForImage,is(image));
}