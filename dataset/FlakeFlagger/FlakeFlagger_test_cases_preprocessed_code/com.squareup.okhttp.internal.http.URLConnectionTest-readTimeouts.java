@Test public void readTimeouts() throws IOException {
InputStream in=connection.getInputStream();//ET
assertEquals('A',in.read());
assertEquals('B',in.read());
assertEquals('C',in.read());
fail();
}