@Test public void verifyRecuperationAfterFailure() throws Exception {
File file=new File(CoreTestConstants.OUTPUT_DIR_PREFIX + "resilient" + diff+ ".log");//RO
Thread.sleep(RecoveryCoordinator.BACKOFF_COEFFICIENT_MIN + 10);
}