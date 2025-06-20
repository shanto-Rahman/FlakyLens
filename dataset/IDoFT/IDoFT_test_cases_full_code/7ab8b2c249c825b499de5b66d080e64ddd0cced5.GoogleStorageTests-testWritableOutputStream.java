@Test public void testWritableOutputStream() throws Exception {
  String location="gs://test-spring/test";
  Blob blob=mock(Blob.class);
  WriteChannel writeChannel=mock(WriteChannel.class);
  when(blob.writer()).thenReturn(writeChannel);
  when(blob.exists()).thenReturn(true);
  when(this.mockStorage.get(BlobId.of("test-spring","test"))).thenReturn(blob);
  GoogleStorageResource resource=new GoogleStorageResource(this.mockStorage,location);
  OutputStream os=resource.getOutputStream();
  Assert.assertNotNull(os);
}
