@Test public void testJobIdXML() throws Exception {
Map<JobId,Job> jobsMap=appContext.getAllJobs();//RW
assertEquals(MediaType.APPLICATION_XML_TYPE + "; " + JettyUtils.UTF_8,response.getType().toString());
is.setCharacterStream(new StringReader(xml));//IT
NodeList job=dom.getElementsByTagName("job");//IT
verifyAMJobXML(job,appContext);//RW
}