@Test public void testTxStats() throws Exception {
Assert.assertTrue("Subsystem boot failed!",kernelServices.isSuccessfulBoot());
Assert.assertEquals("success",result.get("outcome").asString());
Assert.assertEquals(TxStats.getInstance().getNumberOfSystemRollbacks(),result.get(ModelDescriptionConstants.RESULT).asLong());
Assert.assertEquals("success",result.get("outcome").asString());
Assert.assertEquals(TxStats.getInstance().getAverageCommitTime(),result.get(ModelDescriptionConstants.RESULT).asLong());
}