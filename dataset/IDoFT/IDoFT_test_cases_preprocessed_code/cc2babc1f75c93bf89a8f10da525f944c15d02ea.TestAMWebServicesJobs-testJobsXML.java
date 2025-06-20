@Test public void testJobsXML() throws Exception {
assertEquals(MediaType.APPLICATION_XML_TYPE + "; " + JettyUtils.UTF_8,response.getType().toString());
is.setCharacterStream(new StringReader(xml));//IT
NodeList jobs=dom.getElementsByTagName("jobs");//IT
assertEquals("incorrect number of elements",1,jobs.getLength());//IT
NodeList job=dom.getElementsByTagName("job");//IT
assertEquals("incorrect number of elements",1,job.getLength());//IT
verifyAMJobXML(job,appContext);//RW
}