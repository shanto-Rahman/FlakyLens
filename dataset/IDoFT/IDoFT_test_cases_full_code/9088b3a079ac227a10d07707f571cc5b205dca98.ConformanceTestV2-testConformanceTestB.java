public void testConformanceTestB() throws Exception {
  String policyNumber;
  for (int i=1; i < 54; i++) {
    if (i == 28 || i == 29) {
      log.info("Conformance Test IIB00" + i + " does not started As required "+ "attribute finder is not defined");
      continue;
    }
    if (i < 10) {
      policyNumber="00" + i;
    }
 else     if (9 < i && i < 100) {
      policyNumber="0" + i;
    }
 else {
      policyNumber=Integer.toString(i);
    }
    log.info("Conformance Test IIB" + policyNumber + " is started");
    String request=TestUtil.createRequest(ROOT_DIRECTORY,VERSION_DIRECTORY,"IIB" + policyNumber + "Request.xml");
    if (request != null) {
      log.info("Request that is sent to the PDP :  " + request);
      Set<String> policies=new HashSet<String>();
      policies.add("IIB" + policyNumber + "Policy.xml");
      ResponseCtx response=TestUtil.evaluate(getPDPNewInstance(policies),request);
      if (response != null) {
        ResponseCtx expectedResponseCtx=TestUtil.createResponse(ROOT_DIRECTORY,VERSION_DIRECTORY,"IIB" + policyNumber + "Response.xml");
        log.info("Response that is received from the PDP :  " + response.encode());
        if (expectedResponseCtx != null) {
          assertTrue(TestUtil.isMatching(response,expectedResponseCtx));
        }
 else {
          assertTrue("Response read from file is Null",false);
        }
      }
 else {
        assertFalse("Response received PDP is Null",false);
      }
    }
 else {
      assertTrue("Request read from file is Null",false);
    }
    log.info("Conformance Test IIB" + policyNumber + " is finished");
  }
}
