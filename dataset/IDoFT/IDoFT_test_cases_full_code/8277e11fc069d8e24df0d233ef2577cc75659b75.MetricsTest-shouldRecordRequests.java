@Test public void shouldRecordRequests(){
  server.expect(requestTo("http://foo")).andRespond(withSuccess());
  server.expect(requestTo("http://bar")).andRespond(withSuccess());
  foo.get().call(pass()).join();
  bar.get().call(pass()).join();
  final List<Timer> timers=timers("http.client.requests");
  assertEquals(2,timers.size());
  final Timer first=timers.get(0);
  assertEquals("GET",first.getId().getTag("method"));
  assertEquals("bar",first.getId().getTag("clientId"));
  final Timer second=timers.get(1);
  assertEquals("GET",second.getId().getTag("method"));
  assertEquals("foo",second.getId().getTag("clientId"));
}
