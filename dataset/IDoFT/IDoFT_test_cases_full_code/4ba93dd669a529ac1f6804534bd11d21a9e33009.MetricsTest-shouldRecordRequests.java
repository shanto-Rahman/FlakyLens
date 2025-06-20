@Test void shouldRecordRequests(){
  server.expect(requestTo("http://foo")).andRespond(withSuccess());
  server.expect(requestTo("http://bar")).andRespond(withSuccess());
  foo.get().call(pass()).join();
  bar.get().call(pass()).join();
  assertEquals(2,timers("http.client.requests").size());
{
    final Timer timer=registry.find("http.client.requests").tag("client_id","foo").timer();
    assertNotNull(timer);
    assertEquals("GET",timer.getId().getTag("http.method"));
  }
{
    final Timer timer=registry.find("http.client.requests").tag("client_id","bar").timer();
    assertNotNull(timer);
    assertEquals("GET",timer.getId().getTag("http.method"));
  }
}
