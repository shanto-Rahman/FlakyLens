@Test public void testProtocolReadWriteOperation() throws Exception {
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals("jgroups-mping",result.get(RESULT).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals("new-socket-binding",result.get(RESULT).asString());
}