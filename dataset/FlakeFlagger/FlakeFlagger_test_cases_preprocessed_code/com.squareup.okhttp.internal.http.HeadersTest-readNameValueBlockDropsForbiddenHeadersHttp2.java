@Test public void readNameValueBlockDropsForbiddenHeadersHttp2() throws IOException {
assertEquals(1,headers.size());
assertEquals(OkHeaders.SELECTED_PROTOCOL,headers.name(0));
assertEquals(Protocol.HTTP_2.name.utf8(),headers.value(0));
}