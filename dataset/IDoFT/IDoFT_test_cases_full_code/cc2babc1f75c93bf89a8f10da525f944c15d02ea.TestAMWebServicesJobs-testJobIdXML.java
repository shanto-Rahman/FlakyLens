@Test public void testJobIdXML() throws Exception {
  WebResource r=resource();
  Map<JobId,Job> jobsMap=appContext.getAllJobs();
  for (  JobId id : jobsMap.keySet()) {
    String jobId=MRApps.toString(id);
    ClientResponse response=r.path("ws").path("v1").path("mapreduce").path("jobs").path(jobId).accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
    assertEquals(MediaType.APPLICATION_XML_TYPE + "; " + JettyUtils.UTF_8,response.getType().toString());
    String xml=response.getEntity(String.class);
    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
    DocumentBuilder db=dbf.newDocumentBuilder();
    InputSource is=new InputSource();
    is.setCharacterStream(new StringReader(xml));
    Document dom=db.parse(is);
    NodeList job=dom.getElementsByTagName("job");
    verifyAMJobXML(job,appContext);
  }
}
