@Test public void shouldRecordCircuitBreakers(){
  server.expect(requestTo("http://bar")).andRespond(withStatus(SERVICE_UNAVAILABLE));
  server.expect(requestTo("http://bar")).andRespond(withStatus(SERVICE_UNAVAILABLE));
  server.expect(requestTo("http://bar")).andRespond(withStatus(SERVICE_UNAVAILABLE));
  server.expect(requestTo("http://bar")).andRespond(withStatus(SERVICE_UNAVAILABLE));
  server.expect(requestTo("http://bar")).andRespond(withSuccess());
  bar.get().dispatch(status(),on(SERVICE_UNAVAILABLE).call(() -> {
    throw new TransientFaultException();
  }
),anyStatus().call(pass())).join();
  final List<Timer> timers=timers("http.client.circuit-breakers");
  assertEquals(2,timers.size());
  final Timer halfOpen=timers.get(0);
  assertEquals("HALF_OPEN",halfOpen.getId().getTag("state"));
  assertEquals("bar",halfOpen.getId().getTag("clientId"));
  assertEquals(4,halfOpen.count());
  final Timer open=timers.get(1);
  assertEquals("OPEN",open.getId().getTag("state"));
  assertEquals("bar",open.getId().getTag("clientId"));
  assertEquals(4,open.count());
}
