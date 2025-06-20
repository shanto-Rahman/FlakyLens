@Test public void testTargetBetaFile(){
  File file=DiskUtil.targetBetaFile("test1","test2","test3");
  String[] arr=file.getPath().split("\\\\");
  Assert.assertEquals("test1",arr[arr.length - 1]);
  Assert.assertEquals("test2",arr[arr.length - 2]);
  Assert.assertEquals("test3",arr[arr.length - 3]);
  File file2=DiskUtil.targetBetaFile("test1","test2","");
  String[] arr2=file2.getPath().split("\\\\");
  Assert.assertEquals("test1",arr2[arr2.length - 1]);
  Assert.assertEquals("test2",arr2[arr2.length - 2]);
  Assert.assertEquals("beta-data",arr2[arr2.length - 3]);
}
