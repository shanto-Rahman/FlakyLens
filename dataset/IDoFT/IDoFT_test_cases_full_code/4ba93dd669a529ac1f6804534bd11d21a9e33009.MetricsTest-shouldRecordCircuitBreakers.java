@Test void shouldRecordCircuitBreakers(){
  server.expect(requestTo("http://bar")).andRespond(withStatus(SERVICE_UNAVAILABLE));
  server.expect(requestTo("http://bar")).andRespond(withStatus(SERVICE_UNAVAILABLE));
  server.expect(requestTo("http://bar")).andRespond(withStatus(SERVICE_UNAVAILABLE));
  server.expect(requestTo("http://bar")).andRespond(withStatus(SERVICE_UNAVAILABLE));
  server.expect(requestTo("http://bar")).andRespond(withSuccess());
  bar.get().dispatch(status(),on(SERVICE_UNAVAILABLE).call(retry()),anyStatus().call(pass())).join();
  assertEquals(2,timers("http.client.circuit-breakers").size());
{
    final Timer timer=registry.find("http.client.circuit-breakers").tag("state","HALF_OPEN").timer();
    assertNotNull(timer);
    assertEquals("bar",timer.getId().getTag("client_id"));
    assertEquals(4,timer.count());
  }
{
    final Timer timer=registry.find("http.client.circuit-breakers").tag("state","OPEN").timer();
    assertNotNull(timer);
    assertEquals("OPEN",timer.getId().getTag("state"));
    assertEquals("bar",timer.getId().getTag("client_id"));
    assertEquals(4,timer.count());
  }
}
