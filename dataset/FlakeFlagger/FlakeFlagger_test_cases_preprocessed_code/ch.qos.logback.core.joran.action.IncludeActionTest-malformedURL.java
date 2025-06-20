@Test public void malformedURL() throws JoranException {
assertEquals(Status.ERROR,statusChecker.getHighestLevel(0));
assertTrue(statusChecker.containsException(MalformedURLException.class));
}