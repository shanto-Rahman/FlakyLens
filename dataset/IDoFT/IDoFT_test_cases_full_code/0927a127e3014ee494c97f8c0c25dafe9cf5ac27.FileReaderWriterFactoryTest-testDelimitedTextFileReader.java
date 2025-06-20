public void testDelimitedTextFileReader() throws Exception {
  setupDelimitedTextFileWriterConfig();
  mockDelimitedTextFileWriter(false);
  ReflectionUtil.createFileReader(mConfig.getFileReaderWriterFactory(),mLogFilePath,null,mConfig);
  mockDelimitedTextFileWriter(true);
  ReflectionUtil.createFileReader(mConfig.getFileReaderWriterFactory(),mLogFilePathGz,new GzipCodec(),mConfig);
}
