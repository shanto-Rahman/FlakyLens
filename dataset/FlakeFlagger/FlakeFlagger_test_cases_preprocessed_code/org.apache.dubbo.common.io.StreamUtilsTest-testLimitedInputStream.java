@Test public void testLimitedInputStream() throws Exception {
assertThat(10,is(is.available()));
assertThat(2,is(is.available()));
assertThat(is.markSupported(),is(true));
assertEquals((int)'0',is.read());
assertEquals((int)'1',is.read());
assertEquals(-1,is.read());
assertEquals((int)'1',is.read());
assertEquals((int)'0',is.read());
assertThat(read,is(1));
assertEquals(-1,is.read());
}