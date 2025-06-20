@Test public void testWriteUTF() throws IOException {
assertThat(fastJsonObjectInput.readUTF(),is("Pace Hasîtî 和平 Мир"));
}