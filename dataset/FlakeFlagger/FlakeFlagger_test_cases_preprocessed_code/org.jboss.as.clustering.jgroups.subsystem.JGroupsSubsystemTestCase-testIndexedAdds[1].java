/** 
 * Tests that the 'fork' and 'stack' resources allow indexed adds for the 'protocol' children. This is important for the work being done for WFCORE-401. This work involves calculating the operations to bring the slave domain model into sync with the master domain model. Without ordered resources, that would mean on reconnect if the master had added a protocol somewhere in the middle, the protocol would get added to the end rather at the correct place.
 */
@Test public void testIndexedAdds() throws Exception {
if (!this.schema.since(JGroupsSchema.VERSION_3_0)) return;
Assert.assertTrue(originalForkModel.isDefined());
Assert.assertTrue(0 < originalForkModel.get(ProtocolResourceDefinition.WILDCARD_PATH.getKey()).keys().size());
Assert.assertTrue(originalStackModel.isDefined());
Assert.assertEquals(originalForkModel.keys().size() + 1,forkModel.get(ProtocolResourceDefinition.WILDCARD_PATH.getKey()).keys().size());
Assert.assertEquals("MERGE3",forkModel.get(ProtocolResourceDefinition.WILDCARD_PATH.getKey()).keys().iterator().next());
Assert.assertEquals(originalStackModel,stackModel);
}