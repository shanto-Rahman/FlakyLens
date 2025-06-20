@Test public void testWriteUTF() throws IOException {
assertThat(myObjectInput.readUTF(),CoreMatchers.is("Pace"));
assertThat(myObjectInput.readUTF(),CoreMatchers.is("和平"));
assertThat(myObjectInput.readUTF(),CoreMatchers.is(" Мир"));
}