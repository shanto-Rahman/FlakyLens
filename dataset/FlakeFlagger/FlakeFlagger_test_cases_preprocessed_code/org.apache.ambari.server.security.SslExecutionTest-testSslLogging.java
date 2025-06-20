@Test public void testSslLogging() throws Exception {
LOG.info("Testing sign");//RW
certMan.configs.getConfigsMap().put(Configuration.PASSPHRASE_KEY,"123123");//RW
LOG.info("key dir = " + certMan.configs.getConfigsMap().get(Configuration.SRVR_KSTR_DIR_KEY));//RW
SignCertResponse signAgentCrt=certMan.signAgentCrt("somehost","gdfgdfg","123123");//RW
LOG.info("-------------RESPONCE-------------");//RW
LOG.info("-------------MESSAGE--------------");//RW
LOG.info(signAgentCrt.getMessage());//RW
LOG.info("---------------------------------");//RW
LOG.info("-------------RESULT--------------");//RW
LOG.info(signAgentCrt.getResult());//RW
LOG.info("---------------------------------");//RW
assertTrue(SignCertResponse.ERROR_STATUS.equals(signAgentCrt.getResult()));
}