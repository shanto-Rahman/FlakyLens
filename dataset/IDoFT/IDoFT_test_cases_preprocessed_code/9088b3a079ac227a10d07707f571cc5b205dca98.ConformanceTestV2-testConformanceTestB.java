public void testConformanceTestB() throws Exception {
if (i == 28 || i == 29) {
log.info("Conformance Test IIB00" + i + " does not started As required "+ "attribute finder is not defined");//RW
}
if (i < 10) {
if (9 < i && i < 100) {
}
}
log.info("Conformance Test IIB" + policyNumber + " is started");//RW
if (request != null) {
log.info("Request that is sent to the PDP :  " + request);//RW
if (response != null) {
log.info("Response that is received from the PDP :  " + response.encode());//RW
if (expectedResponseCtx != null) {
assertTrue(TestUtil.isMatching(response,expectedResponseCtx));
assertTrue("Response read from file is Null",false);
}
assertFalse("Response received PDP is Null",false);
}
assertTrue("Request read from file is Null",false);
}
log.info("Conformance Test IIB" + policyNumber + " is finished");//RW
}