@Test public void shouldRecordRetries(){
  server.expect(requestTo("http://foo")).andRespond(withStatus(SERVICE_UNAVAILABLE));
  server.expect(requestTo("http://foo")).andRespond(withStatus(SERVICE_UNAVAILABLE));
  server.expect(requestTo("http://foo")).andRespond(withSuccess());
  foo.get().dispatch(status(),on(SERVICE_UNAVAILABLE).call(retry()),anyStatus().call(pass())).join();
  final List<Timer> timers=timers("http.client.retries");
  assertEquals(2,timers.size());
  final Timer first=timers.get(0);
  assertEquals("1",first.getId().getTag("retries"));
  assertEquals("foo",first.getId().getTag("clientId"));
  final Timer second=timers.get(1);
  assertEquals("2",second.getId().getTag("retries"));
  assertEquals("foo",second.getId().getTag("clientId"));
}
