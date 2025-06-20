/** 
 * Tests reading blocks marked for deletion from a container written in schema version 1. Because the block deleting service both reads for deleted blocks and deletes them, this test will modify its copy of the database.
 */
@Test public void testDelete() throws Exception {
assertEquals(expectedDeletingBlocks,countDeletingBlocks(refCountedDB));
assertEquals(expectedDeletedBlocks,TestDB.NUM_DELETED_BLOCKS + numberOfBlocksDeleted);
assertEquals(expectedRegularBlocks,countUnprefixedBlocks(refCountedDB));
assertEquals(expectedRegularBlocks + expectedDeletingBlocks,(long)metadataTable.get(OzoneConsts.BLOCK_COUNT));
}