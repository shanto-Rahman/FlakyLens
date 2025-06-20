@Test public void testWriteChunkStageWriteAndCommit() throws Exception {
File tempChunkFile=new File(chunkFile.getParent(),chunkFile.getName() + OzoneConsts.CONTAINER_CHUNK_NAME_DELIMITER + OzoneConsts.CONTAINER_TEMPORARY_CHUNK_PREFIX+ OzoneConsts.CONTAINER_CHUNK_NAME_DELIMITER+ term+ OzoneConsts.CONTAINER_CHUNK_NAME_DELIMITER+ index);
assertTrue(tempChunkFile.exists());
assertTrue(chunkFile.exists());
assertFalse(tempChunkFile.exists());
}