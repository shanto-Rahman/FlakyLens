@Test public void testGetFiles() throws Exception {
  System.out.println("getFiles");
  instance.createBucket("test-files");
  refreshInstance();
  List<String> files=ImmutableList.of("s3:/test-files/rootfile.nc","s3:/test-files/dir1/dir2/nested_file1.nc","s3:/test-files/dir1/dir2/nested_file2.nc","s3:/test-files/dir1/dir2/nested_file3.nc");
  for (  String uri : files) {
    instance.uploadFile(createFileWith("some-data".getBytes()),uri);
  }
  File[] rootFiles=instance.getFiles(new S3VirtualFile("s3:/test-files/",0),true);
  Assertions.assertThat(rootFiles).hasSize(2);
  for (  File f : rootFiles) {
    if (f.isDirectory()) {
      Assertions.assertThat(f.getName()).isEqualTo("dir1");
    }
 else {
      Assertions.assertThat(f.getName()).isEqualTo("rootfile.nc");
    }
  }
  File[] middleDir=instance.getFiles(new S3VirtualFile("s3:/test-files/dir1/",0),true);
  Assertions.assertThat(middleDir).hasSize(1);
  for (  File f : middleDir) {
    Assertions.assertThat(f.isDirectory()).isTrue();
    Assertions.assertThat(f.getName()).isEqualTo("dir2");
  }
  File[] leaves=instance.getFiles(new S3VirtualFile("s3:/test-files/dir1/dir2",0),true);
  Assertions.assertThat(leaves).hasSize(3);
  for (  File f : leaves) {
    Assertions.assertThat(f.isDirectory()).isFalse();
    Assertions.assertThat(f.getName()).matches("nested_file\\d\\.nc");
  }
}
