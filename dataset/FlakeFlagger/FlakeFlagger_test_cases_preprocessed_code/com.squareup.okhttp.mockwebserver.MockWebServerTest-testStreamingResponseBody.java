public void testStreamingResponseBody() throws Exception {
assertEquals('A',in.read());
assertEquals('B',in.read());
assertEquals('C',in.read());
assertEquals(-1,responseBody.read());
}