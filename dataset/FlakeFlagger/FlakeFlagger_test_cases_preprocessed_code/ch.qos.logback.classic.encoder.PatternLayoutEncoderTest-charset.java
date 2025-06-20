@Test public void charset() throws IOException {
assertEquals(msg,new String(baos.toByteArray(),utf8Charset.name()));
}