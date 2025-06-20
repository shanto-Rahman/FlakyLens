@Test public void LOGBACK744_withColon() throws ScanException {
assertEquals("%d{HH:mm:ss.SSS} host:local %logger{36} - %msg%n",nodeToStringTransformer.transform());
}