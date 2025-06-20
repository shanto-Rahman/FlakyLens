@Test public void testAddCookieViaResult(){
assertThat(resultCookie.getName(),equalTo("cookie"));
assertThat(resultCookie.getValue(),equalTo("yum"));
assertThat(resultCookie.getPath(),equalTo("/"));
assertThat(resultCookie.getSecure(),equalTo(false));
assertThat(resultCookie.getMaxAge(),equalTo(-1));
}