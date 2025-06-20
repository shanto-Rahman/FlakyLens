@Test public void redirectedFromHttpToHttpsFollowingProtocolRedirects() throws Exception {
assertFalse(connection instanceof HttpsURLConnection);
}