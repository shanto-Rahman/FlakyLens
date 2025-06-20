/** 
 * Tests the ability of the /subsystem=jgroups/stack=X:add() operation to correctly process the optional TRANSPORT and PROTOCOLS parameters.
 */
@Test public void testProtocolStackAddRemoveSequenceWithParameters() throws Exception {
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(FAILED,result.get(OUTCOME).asString());
}