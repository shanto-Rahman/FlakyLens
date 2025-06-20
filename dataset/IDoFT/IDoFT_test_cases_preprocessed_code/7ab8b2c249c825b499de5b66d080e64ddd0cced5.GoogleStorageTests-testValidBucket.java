@Test public void testValidBucket() throws IOException {
Assert.assertEquals("gs://test-spring/",this.bucketResource.getDescription());
Assert.assertEquals("test-spring",this.bucketResource.getFilename());
Assert.assertEquals("gs://test-spring/",this.bucketResource.getURI().toString());
Assert.assertEquals("gs://test-spring/aaa/bbb",relative);
Assert.assertEquals(relative,this.bucketResource.createRelative("/aaa/bbb").getURI().toString());
Assert.assertNull(((GoogleStorageResource)this.bucketResource).getBlobName());
Assert.assertTrue(((GoogleStorageResource)this.bucketResource).isBucket());
Assert.assertTrue(this.bucketResource.exists());
Assert.assertTrue(((GoogleStorageResource)this.bucketResource).bucketExists());
}