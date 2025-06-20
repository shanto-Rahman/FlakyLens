@Test public void testUpdateClientRedirectURI(){
assertEquals("newClientIdWithNoDetails",map.get("client_id"));
assertTrue(map.containsKey("web_server_redirect_uri"));
assertEquals("http://localhost:8080,http://localhost:9090",map.get("web_server_redirect_uri"));
}