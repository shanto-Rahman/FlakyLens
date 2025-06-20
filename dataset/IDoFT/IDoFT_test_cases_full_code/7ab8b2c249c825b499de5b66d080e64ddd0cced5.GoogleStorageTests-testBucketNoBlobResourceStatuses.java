@Test public void testBucketNoBlobResourceStatuses() throws IOException {
  Assert.assertFalse(this.bucketResource.isOpen());
  Assert.assertFalse(this.bucketResource.isReadable());
  Assert.assertFalse(((WritableResource)this.bucketResource).isWritable());
  Assert.assertTrue(this.bucketResource.exists());
}
