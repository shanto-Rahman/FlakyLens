@Test public void testGetWsdl() throws Exception {
  URL url=new URL("http://localhost:" + PORT + "/SoapContext/SoapPort?wsdl");
  InputStream in=url.openStream();
  ByteArrayOutputStream bos=new ByteArrayOutputStream();
  IOUtils.copyAndCloseInput(in,bos);
  String result=bos.toString();
  assertTrue("Expect the SOAPService",result.indexOf("<service name=\"SOAPService\">") > 0);
}
