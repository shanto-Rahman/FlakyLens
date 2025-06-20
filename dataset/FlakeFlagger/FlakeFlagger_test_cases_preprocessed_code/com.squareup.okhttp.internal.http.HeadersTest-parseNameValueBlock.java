@Test public void parseNameValueBlock() throws IOException {
assertEquals(4,headers.size());
assertEquals("HTTP/1.1 200 OK",response.statusLine());
assertEquals("no-cache, no-store",headers.get("cache-control"));
assertEquals("Cookie2",headers.get("set-cookie"));
assertEquals(Protocol.SPDY_3.name.utf8(),headers.get(OkHeaders.SELECTED_PROTOCOL));
assertEquals(OkHeaders.SELECTED_PROTOCOL,headers.name(0));
assertEquals(Protocol.SPDY_3.name.utf8(),headers.value(0));
assertEquals("cache-control",headers.name(1));
assertEquals("no-cache, no-store",headers.value(1));
assertEquals("set-cookie",headers.name(2));
assertEquals("Cookie1",headers.value(2));
assertEquals("set-cookie",headers.name(3));
assertEquals("Cookie2",headers.value(3));
assertNull(headers.get(":status"));
assertNull(headers.get(":version"));
}