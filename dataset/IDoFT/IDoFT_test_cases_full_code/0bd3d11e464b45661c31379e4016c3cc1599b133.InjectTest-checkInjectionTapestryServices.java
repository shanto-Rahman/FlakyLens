@Test @InSequence(3) public void checkInjectionTapestryServices() throws IOException {
  String output=getResponse(indexUrl);
  assertTrue("Injection of Tapestry Service Messages by CDI annotation failed in page Index",output.contains("message_cdi"));
  assertTrue("Injection of Tapestry Service Messages by Tapestry annotation failed in page Index",output.contains("message_tapestry"));
}
