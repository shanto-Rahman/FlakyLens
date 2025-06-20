/** 
 * Tests the  {@link BulkDecompressor.Decompress} when a matched file does not match a knowncompression.
 */
@Test public void testDecompressUnknownCompressionFile() throws Exception {
final ValueProvider<String> outputDirectory=pipeline.newProvider(tempFolderOutputPath.toString());//RW
final Metadata unknownCompressionFileMetadata=FileSystems.matchSingleFileSpec(unknownCompressionFile.toString());//RW
assertThat(kv.getKey(),is(equalTo(unknownCompressionFileMetadata.resourceId().toString())));
assertThat(kv.getValue(),containsString(String.format(BulkDecompressor.UNCOMPRESSED_ERROR_MSG,unknownCompressionFile.toString(),BulkDecompressor.SUPPORTED_COMPRESSIONS)));//RW
}