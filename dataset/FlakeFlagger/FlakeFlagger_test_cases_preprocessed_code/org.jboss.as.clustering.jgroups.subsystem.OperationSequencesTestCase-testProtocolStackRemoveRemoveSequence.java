@Test public void testProtocolStackRemoveRemoveSequence() throws Exception {
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(FAILED,result.get(OUTCOME).asString());
}