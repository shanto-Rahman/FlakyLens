@Test public void noFileFound() throws JoranException {
assertEquals(Status.ERROR,statusChecker.getHighestLevel(0));
assertTrue(statusChecker.containsException(FileNotFoundException.class));
}