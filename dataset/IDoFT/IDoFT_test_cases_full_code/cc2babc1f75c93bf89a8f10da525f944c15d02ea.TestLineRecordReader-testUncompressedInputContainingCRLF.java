@Test public void testUncompressedInputContainingCRLF() throws Exception {
  Configuration conf=new Configuration();
  String inputData="a\r\nb\rc\nd\r\n";
  Path inputFile=createInputFile(conf,inputData);
  for (int bufferSize=1; bufferSize <= inputData.length(); bufferSize++) {
    for (int splitSize=1; splitSize < inputData.length(); splitSize++) {
      conf.setInt("io.file.buffer.size",bufferSize);
      testSplitRecordsForFile(conf,splitSize,inputData.length(),inputFile);
    }
  }
}
