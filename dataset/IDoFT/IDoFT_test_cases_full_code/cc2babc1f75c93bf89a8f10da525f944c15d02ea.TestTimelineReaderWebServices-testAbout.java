@Test public void testAbout() throws Exception {
  URI uri=URI.create("http://localhost:" + serverPort + "/ws/v2/timeline/");
  Client client=createClient();
  try {
    ClientResponse resp=getResponse(client,uri);
    TimelineAbout about=resp.getEntity(TimelineAbout.class);
    Assert.assertNotNull(about);
    Assert.assertEquals("Timeline Reader API",about.getAbout());
  }
  finally {
    client.destroy();
  }
}
