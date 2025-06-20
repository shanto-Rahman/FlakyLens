/** 
 * Tests the  {@link BulkDecompressor.Decompress} when a matched file does not match a knowncompression.
 */
@Test public void testDecompressUnknownCompressionFile() throws Exception {
  final ValueProvider<String> outputDirectory=pipeline.newProvider(tempFolderOutputPath.toString());
  final Metadata unknownCompressionFileMetadata=FileSystems.matchSingleFileSpec(unknownCompressionFile.toString());
  PCollectionTuple decompressOut=pipeline.apply("CreateWorkItems",Create.of(unknownCompressionFileMetadata)).apply("Decompress",ParDo.of(new Decompress(outputDirectory)).withOutputTags(DECOMPRESS_MAIN_OUT_TAG,TupleTagList.of(DEADLETTER_TAG)));
  PAssert.that(decompressOut.get(DECOMPRESS_MAIN_OUT_TAG)).empty();
  PAssert.that(decompressOut.get(DEADLETTER_TAG)).satisfies(collection -> {
    KV<String,String> kv=collection.iterator().next();
    assertThat(kv.getKey(),is(equalTo(unknownCompressionFileMetadata.resourceId().toString())));
    assertThat(kv.getValue(),containsString(String.format(BulkDecompressor.UNCOMPRESSED_ERROR_MSG,unknownCompressionFile.toString(),BulkDecompressor.SUPPORTED_COMPRESSIONS)));
    return null;
  }
);
  pipeline.run();
}
