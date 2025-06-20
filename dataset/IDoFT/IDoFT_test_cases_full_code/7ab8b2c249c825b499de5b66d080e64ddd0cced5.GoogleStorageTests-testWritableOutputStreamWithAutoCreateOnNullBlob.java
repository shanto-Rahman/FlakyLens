@Test public void testWritableOutputStreamWithAutoCreateOnNullBlob() throws Exception {
  String location="gs://test-spring/test";
  BlobId blobId=BlobId.of("test-spring","test");
  when(this.mockStorage.get(blobId)).thenReturn(null);
  BlobInfo blobInfo=BlobInfo.newBuilder(blobId).build();
  WriteChannel writeChannel=mock(WriteChannel.class);
  Blob blob=mock(Blob.class);
  when(blob.writer()).thenReturn(writeChannel);
  when(this.mockStorage.create(blobInfo)).thenReturn(blob);
  GoogleStorageResource resource=new GoogleStorageResource(this.mockStorage,location);
  GoogleStorageResource spyResource=spy(resource);
  OutputStream os=spyResource.getOutputStream();
  Assert.assertNotNull(os);
}
