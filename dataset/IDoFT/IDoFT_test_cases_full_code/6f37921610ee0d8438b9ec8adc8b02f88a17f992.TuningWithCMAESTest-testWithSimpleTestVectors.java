@Test public void testWithSimpleTestVectors() throws Exception {
  SecurityScoreExample score=new SecurityScoreExample();
  ScoreVerification verification=new ScoreVerification(score,SIMPLE_TEST_VECTORS);
  assertNotNull(verification);
  new TuningWithCMAES(score,new ScoreVerifier(score,SIMPLE_TEST_VECTORS)).run();
  verification.run();
}
