@Test public void testContainerCacheEviction() throws Exception {
File root=new File(testRoot);//RO//RW
Assert.assertEquals(0,cache.size());
File containerDir1=new File(root,"cont1");
File containerDir2=new File(root,"cont2");
File containerDir3=new File(root,"cont3");
File containerDir4=new File(root,"cont4");
Assert.assertEquals(1,db1.getReferenceCount());
Assert.assertEquals(numDbGetCount + 1,metrics.getNumDbGetOps());
Assert.assertEquals(2,db2.getReferenceCount());
Assert.assertEquals(numCacheMisses + 1,metrics.getNumCacheMisses());
Assert.assertEquals(2,db1.getReferenceCount());
Assert.assertEquals(db1,db2);
Assert.assertEquals(numDbGetCount + 2,metrics.getNumDbGetOps());
Assert.assertEquals(numCacheMisses + 1,metrics.getNumCacheMisses());
Assert.assertEquals(1,db3.getReferenceCount());
Assert.assertEquals(0,db3.getReferenceCount());
Assert.assertEquals(1,db4.getReferenceCount());
Assert.assertEquals(2,cache.size());
Assert.assertNotNull(cache.get(containerDir1.getPath()));
Assert.assertNull(cache.get(containerDir2.getPath()));
Assert.assertEquals(0,db1.getReferenceCount());
Assert.assertEquals(0,db2.getReferenceCount());
Assert.assertEquals(1,db5.getReferenceCount());
Assert.assertEquals(db1,db5);
}