/** 
 * Tests access to subsystem attributes
 */
@Test public void testSubsystemReadWriteOperations() throws Exception {
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals("ee",result.get(RESULT).asString());
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals("bridge",result.get(RESULT).asString());
}