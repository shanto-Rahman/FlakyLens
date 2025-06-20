@Test public void testUncompressedInputCustomDelimiterPosValue() throws Exception {
  Configuration conf=new Configuration();
  conf.setInt("io.file.buffer.size",10);
  conf.setInt(org.apache.hadoop.mapreduce.lib.input.LineRecordReader.MAX_LINE_LENGTH,Integer.MAX_VALUE);
  String inputData="abcdefghij++kl++mno";
  Path inputFile=createInputFile(conf,inputData);
  String delimiter="++";
  byte[] recordDelimiterBytes=delimiter.getBytes(StandardCharsets.UTF_8);
  int splitLength=15;
  FileSplit split=new FileSplit(inputFile,0,splitLength,(String[])null);
  TaskAttemptContext context=new TaskAttemptContextImpl(conf,new TaskAttemptID());
  LineRecordReader reader=new LineRecordReader(recordDelimiterBytes);
  reader.initialize(split,context);
  assertTrue("Expected record got nothing",reader.nextKeyValue());
  LongWritable key=reader.getCurrentKey();
  Text value=reader.getCurrentValue();
  assertEquals("Wrong length for record value",10,value.getLength());
  assertEquals("Wrong position after record read",0,key.get());
  assertTrue("Expected record got nothing",reader.nextKeyValue());
  assertEquals("Wrong length for record value",2,value.getLength());
  assertEquals("Wrong position after record read",12,key.get());
  assertTrue("Expected record got nothing",reader.nextKeyValue());
  assertEquals("Wrong length for record value",3,value.getLength());
  assertEquals("Wrong position after record read",16,key.get());
  assertFalse(reader.nextKeyValue());
  assertEquals("Wrong position after record read",19,key.get());
  key=reader.getCurrentKey();
  assertNull("Unexpected key returned",key);
  reader.close();
  split=new FileSplit(inputFile,splitLength,inputData.length() - splitLength,(String[])null);
  reader=new LineRecordReader(recordDelimiterBytes);
  reader.initialize(split,context);
  assertFalse("Unexpected record returned",reader.nextKeyValue());
  key=reader.getCurrentKey();
  assertNull("Unexpected key returned",key);
  reader.close();
  inputData="abcd+efgh++ijk++mno";
  inputFile=createInputFile(conf,inputData);
  splitLength=5;
  split=new FileSplit(inputFile,0,splitLength,(String[])null);
  reader=new LineRecordReader(recordDelimiterBytes);
  reader.initialize(split,context);
  assertTrue("Expected record got nothing",reader.nextKeyValue());
  key=reader.getCurrentKey();
  value=reader.getCurrentValue();
  assertEquals("Wrong position after record read",0,key.get());
  assertEquals("Wrong length for record value",9,value.getLength());
  assertFalse(reader.nextKeyValue());
  assertEquals("Wrong position after record read",11,key.get());
  key=reader.getCurrentKey();
  assertNull("Unexpected key returned",key);
  reader.close();
  split=new FileSplit(inputFile,splitLength,inputData.length() - splitLength,(String[])null);
  reader=new LineRecordReader(recordDelimiterBytes);
  reader.initialize(split,context);
  assertTrue("Expected record got nothing",reader.nextKeyValue());
  key=reader.getCurrentKey();
  value=reader.getCurrentValue();
  assertEquals("Wrong position after record read",11,key.get());
  assertEquals("Wrong length for record value",3,value.getLength());
  assertTrue("Expected record got nothing",reader.nextKeyValue());
  assertEquals("Wrong position after record read",16,key.get());
  assertEquals("Wrong length for record value",3,value.getLength());
  assertFalse(reader.nextKeyValue());
  assertEquals("Wrong position after record read",19,key.get());
  reader.close();
  inputData="abcd|efgh|+|ij|kl|+|mno|pqr";
  inputFile=createInputFile(conf,inputData);
  delimiter="|+|";
  recordDelimiterBytes=delimiter.getBytes(StandardCharsets.UTF_8);
  for (int bufferSize=1; bufferSize <= inputData.length(); bufferSize++) {
    for (int splitSize=1; splitSize < inputData.length(); splitSize++) {
      int keyPosition=0;
      conf.setInt("io.file.buffer.size",bufferSize);
      split=new FileSplit(inputFile,0,bufferSize,(String[])null);
      reader=new LineRecordReader(recordDelimiterBytes);
      reader.initialize(split,context);
      assertTrue("Expected record got nothing",reader.nextKeyValue());
      key=reader.getCurrentKey();
      value=reader.getCurrentValue();
      assertTrue("abcd|efgh".equals(value.toString()));
      assertEquals("Wrong position after record read",keyPosition,key.get());
      keyPosition=12;
      if (reader.nextKeyValue()) {
        assertTrue("ij|kl".equals(value.toString()));
        assertEquals("Wrong position after record read",keyPosition,key.get());
        keyPosition=20;
      }
      if (reader.nextKeyValue()) {
        assertTrue("mno|pqr".equals(value.toString()));
        assertEquals("Wrong position after record read",keyPosition,key.get());
        keyPosition=inputData.length();
      }
      assertFalse("Unexpected record returned",reader.nextKeyValue());
      assertEquals("Wrong position after record read",keyPosition,key.get());
      key=reader.getCurrentKey();
      assertNull("Unexpected key returned",key);
      reader.close();
    }
  }
}
