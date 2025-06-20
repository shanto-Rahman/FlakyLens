@SuppressWarnings("unchecked") @Test(timeout=10000) public void testCopyFromHostWithRetryUnreserve() throws Exception {
  InMemoryMapOutput<Text,Text> immo=mock(InMemoryMapOutput.class);
  Fetcher<Text,Text> underTest=new FakeFetcher<Text,Text>(jobWithRetry,id,ss,mm,r,metrics,except,key,connection);
  String replyHash=SecureShuffleUtils.generateHash(encHash.getBytes(),key);
  when(connection.getResponseCode()).thenReturn(200);
  when(connection.getHeaderField(SecureShuffleUtils.HTTP_HEADER_REPLY_URL_HASH)).thenReturn(replyHash);
  ShuffleHeader header=new ShuffleHeader(map1ID.toString(),10,10,1);
  ByteArrayOutputStream bout=new ByteArrayOutputStream();
  header.write(new DataOutputStream(bout));
  ByteArrayInputStream in=new ByteArrayInputStream(bout.toByteArray());
  when(connection.getInputStream()).thenReturn(in);
  when(connection.getHeaderField(ShuffleHeader.HTTP_HEADER_NAME)).thenReturn(ShuffleHeader.DEFAULT_HTTP_HEADER_NAME);
  when(connection.getHeaderField(ShuffleHeader.HTTP_HEADER_VERSION)).thenReturn(ShuffleHeader.DEFAULT_HTTP_HEADER_VERSION);
  when(mm.reserve(any(TaskAttemptID.class),anyLong(),anyInt())).thenReturn(immo);
  doThrow(new IOException("forced error")).when(immo).shuffle(any(MapHost.class),any(InputStream.class),anyLong(),anyLong(),any(ShuffleClientMetrics.class),any(Reporter.class));
  underTest.copyFromHost(host);
  verify(immo).abort();
}
