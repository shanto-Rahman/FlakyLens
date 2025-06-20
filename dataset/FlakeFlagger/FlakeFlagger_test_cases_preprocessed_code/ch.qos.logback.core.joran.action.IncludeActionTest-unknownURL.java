@Test public void unknownURL() throws JoranException {
assertEquals(Status.ERROR,statusChecker.getHighestLevel(0));
assertTrue(statusChecker.containsException(UnknownHostException.class) || statusChecker.containsException(IOException.class));
}