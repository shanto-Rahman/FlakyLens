public void testSequenceFileReader() throws Exception {
  setupSequenceFileReaderConfig();
  mockSequenceFileWriter(false);
  ReflectionUtil.createFileReader(mConfig.getFileReaderWriterFactory(),mLogFilePath,null,mConfig);
  mockSequenceFileWriter(true);
  ReflectionUtil.createFileWriter(mConfig.getFileReaderWriterFactory(),mLogFilePathGz,new GzipCodec(),mConfig);
}
