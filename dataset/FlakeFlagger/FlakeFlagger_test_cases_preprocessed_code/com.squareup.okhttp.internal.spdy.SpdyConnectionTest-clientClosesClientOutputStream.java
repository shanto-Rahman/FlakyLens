@Test public void clientClosesClientOutputStream() throws Exception {
assertEquals(1,connection.openStreamCount());
fail();
assertEquals("closed",expected.getMessage());
assertEquals(0,connection.openStreamCount());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertFalse(synStream.inFinished);
assertTrue(synStream.outFinished);
assertEquals(TYPE_DATA,data.type);
assertFalse(data.inFinished);
assertTrue(Arrays.equals("square".getBytes("UTF-8"),data.data));
assertEquals(TYPE_DATA,fin.type);
assertTrue(fin.inFinished);
assertEquals(TYPE_PING,ping.type);
assertEquals(1,ping.payload1);
}