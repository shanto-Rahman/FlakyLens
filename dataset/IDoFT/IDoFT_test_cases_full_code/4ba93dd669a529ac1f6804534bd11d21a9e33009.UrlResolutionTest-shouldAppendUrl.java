@Test void shouldAppendUrl(){
  server.expect(requestTo("https://example.com/foo/bar")).andRespond(withSuccess());
  unit.get("/bar").call(pass()).join();
  server.verify();
}
