/** 
 * Tests reading the chunk info saved from a block that was deleted from a database in schema version one. Blocks deleted from schema version one before the upgrade will have the block ID saved as their value. Trying to retrieve this value as a  {@link ChunkInfoList} should fail. Blocksdeleted from schema version one after the upgrade should have their {@link ChunkInfoList} saved as the corresponding value in the deletedblocks table. Reading these values should succeed.
 * @throws Exception
 */
@Test public void testReadDeletedBlockChunkInfo() throws Exception {
Assert.fail("No exception thrown when trying to retrieve old " + "deleted blocks values as chunk lists.");
Assert.assertEquals(TestDB.NUM_DELETED_BLOCKS,preUpgradeBlocks.size());
Assert.assertEquals(TestDB.NUM_PENDING_DELETION_BLOCKS,numberOfBlocksDeleted);
}