@Test public void testUncompressedInput() throws Exception {
  Configuration conf=new Configuration();
  String inputData="abc+def+ghi+jkl+mno+pqr+stu+vw +xyz";
  Path inputFile=createInputFile(conf,inputData);
  conf.set("textinputformat.record.delimiter","+");
  for (int bufferSize=1; bufferSize <= inputData.length(); bufferSize++) {
    for (int splitSize=1; splitSize < inputData.length(); splitSize++) {
      conf.setInt("io.file.buffer.size",bufferSize);
      testSplitRecordsForFile(conf,splitSize,inputData.length(),inputFile);
    }
  }
  inputData="abc|+|def|+|ghi|+|jkl|+|mno|+|pqr|+|stu|+|vw |+|xyz";
  inputFile=createInputFile(conf,inputData);
  conf.set("textinputformat.record.delimiter","|+|");
  for (int bufferSize=1; bufferSize <= inputData.length(); bufferSize++) {
    for (int splitSize=1; splitSize < inputData.length(); splitSize++) {
      conf.setInt("io.file.buffer.size",bufferSize);
      testSplitRecordsForFile(conf,splitSize,inputData.length(),inputFile);
    }
  }
  inputData="abc+def++ghi+jkl++mno+pqr++stu+vw ++xyz";
  inputFile=createInputFile(conf,inputData);
  conf.set("textinputformat.record.delimiter","+");
  for (int bufferSize=1; bufferSize <= inputData.length(); bufferSize++) {
    for (int splitSize=1; splitSize < inputData.length(); splitSize++) {
      conf.setInt("io.file.buffer.size",bufferSize);
      testSplitRecordsForFile(conf,splitSize,inputData.length(),inputFile);
    }
  }
  inputData="abc|+||+|defghi|+|jkl|+||+|mno|+|pqr|+||+|stu|+|vw |+||+|xyz";
  inputFile=createInputFile(conf,inputData);
  conf.set("textinputformat.record.delimiter","|+|");
  for (int bufferSize=1; bufferSize <= inputData.length(); bufferSize++) {
    for (int splitSize=1; splitSize < inputData.length(); splitSize++) {
      conf.setInt("io.file.buffer.size",bufferSize);
      testSplitRecordsForFile(conf,splitSize,inputData.length(),inputFile);
    }
  }
  inputData="abc+def+-ghi+jkl+-mno+pqr+-stu+vw +-xyz";
  inputFile=createInputFile(conf,inputData);
  conf.set("textinputformat.record.delimiter","+-");
  for (int bufferSize=1; bufferSize <= inputData.length(); bufferSize++) {
    for (int splitSize=1; splitSize < inputData.length(); splitSize++) {
      conf.setInt("io.file.buffer.size",bufferSize);
      testSplitRecordsForFile(conf,splitSize,inputData.length(),inputFile);
    }
  }
  inputData="abc\n+def\n+ghi\n+jkl\n+mno";
  inputFile=createInputFile(conf,inputData);
  conf.set("textinputformat.record.delimiter","\n+");
  for (int bufferSize=1; bufferSize <= inputData.length(); bufferSize++) {
    for (int splitSize=1; splitSize < inputData.length(); splitSize++) {
      conf.setInt("io.file.buffer.size",bufferSize);
      testSplitRecordsForFile(conf,splitSize,inputData.length(),inputFile);
    }
  }
  inputData="abc\ndef+\nghi+\njkl\nmno";
  inputFile=createInputFile(conf,inputData);
  conf.set("textinputformat.record.delimiter","+\n");
  for (int bufferSize=1; bufferSize <= inputData.length(); bufferSize++) {
    for (int splitSize=1; splitSize < inputData.length(); splitSize++) {
      conf.setInt("io.file.buffer.size",bufferSize);
      testSplitRecordsForFile(conf,splitSize,inputData.length(),inputFile);
    }
  }
}
