@Test public void testExtractLogs(){
Assert.assertEquals(1,this.logsBuffer.size());
Assert.assertEquals(this.logsBuffer.get(0).toString(),expectedPayload);
}