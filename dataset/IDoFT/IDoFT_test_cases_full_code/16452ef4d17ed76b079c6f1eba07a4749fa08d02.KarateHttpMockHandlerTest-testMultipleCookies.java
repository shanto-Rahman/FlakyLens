@Test void testMultipleCookies(){
  background().scenario("pathMatches('/hello')","def response = requestHeaders");
  startMockServer();
  run(urlStep(),"path 'hello'","cookie cookie1 = 'foo'","cookie cookie2 = 'bar'","method get");
  matchVarContains("response","{ cookie: ['cookie1=foo; cookie2=bar'] }");
}
