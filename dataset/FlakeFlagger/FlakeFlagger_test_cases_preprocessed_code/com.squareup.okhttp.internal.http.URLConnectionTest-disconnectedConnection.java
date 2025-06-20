@Test public void disconnectedConnection() throws IOException {
assertEquals('A',(char)in.read());
fail("Expected a connection closed exception");
}