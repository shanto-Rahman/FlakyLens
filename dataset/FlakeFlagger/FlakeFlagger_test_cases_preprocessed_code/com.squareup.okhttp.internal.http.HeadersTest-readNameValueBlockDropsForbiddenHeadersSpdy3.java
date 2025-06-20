@Test public void readNameValueBlockDropsForbiddenHeadersSpdy3() throws IOException {
assertEquals(1,headers.size());
assertEquals(OkHeaders.SELECTED_PROTOCOL,headers.name(0));
assertEquals(Protocol.SPDY_3.name.utf8(),headers.value(0));
}