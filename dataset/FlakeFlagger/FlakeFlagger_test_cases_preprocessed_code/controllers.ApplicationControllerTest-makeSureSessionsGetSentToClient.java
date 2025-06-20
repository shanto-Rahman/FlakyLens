@Test public void makeSureSessionsGetSentToClient(){
assertEquals(1,ninjaTestBrowser.getCookies().size());
assertTrue(cookie != null);
assertTrue(cookie.getValue().contains("___TS"));
assertTrue(cookie.getValue().contains("username"));
assertTrue(cookie.getValue().contains("kevin"));
}