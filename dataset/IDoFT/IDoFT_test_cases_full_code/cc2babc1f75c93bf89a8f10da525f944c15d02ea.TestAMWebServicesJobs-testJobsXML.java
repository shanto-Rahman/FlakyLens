@Test public void testJobsXML() throws Exception {
  WebResource r=resource();
  ClientResponse response=r.path("ws").path("v1").path("mapreduce").path("jobs").accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
  assertEquals(MediaType.APPLICATION_XML_TYPE + "; " + JettyUtils.UTF_8,response.getType().toString());
  String xml=response.getEntity(String.class);
  DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
  DocumentBuilder db=dbf.newDocumentBuilder();
  InputSource is=new InputSource();
  is.setCharacterStream(new StringReader(xml));
  Document dom=db.parse(is);
  NodeList jobs=dom.getElementsByTagName("jobs");
  assertEquals("incorrect number of elements",1,jobs.getLength());
  NodeList job=dom.getElementsByTagName("job");
  assertEquals("incorrect number of elements",1,job.getLength());
  verifyAMJobXML(job,appContext);
}
