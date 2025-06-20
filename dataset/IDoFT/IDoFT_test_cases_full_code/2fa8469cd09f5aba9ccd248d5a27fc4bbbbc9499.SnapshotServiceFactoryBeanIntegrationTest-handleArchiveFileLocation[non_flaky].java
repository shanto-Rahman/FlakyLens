@Test public void handleArchiveFileLocation() throws Exception {
  File cacheSnapshotZipDirectory=null;
  try {
    File cacheSnapshotZip=new ClassPathResource("/cache_snapshot.zip").getFile();
    File[] actualSnapshots=snapshotService.handleFileLocation(cacheSnapshotZip);
    assertThat(actualSnapshots,is(notNullValue()));
    assertThat(actualSnapshots.length,is(equalTo(3)));
    assertThat(toFilenames(actualSnapshots).containsAll(Arrays.asList("accounts.snapshot","address.snapshot","people.snapshot")),is(true));
    cacheSnapshotZipDirectory=new File(System.getProperty("java.io.tmpdir"),cacheSnapshotZip.getName().replaceAll("\\.","-"));
    assertThat(cacheSnapshotZipDirectory.isDirectory(),is(true));
    File[] expectedSnapshots=cacheSnapshotZipDirectory.listFiles(FileSystemUtils.FileOnlyFilter.INSTANCE);
    Arrays.sort(expectedSnapshots,(f1,f2) -> (f1.compareTo(f2)));
    Arrays.sort(actualSnapshots,(f1,f2) -> (f1.compareTo(f2)));
    assertThat(expectedSnapshots,is(equalTo(actualSnapshots)));
  }
  finally {
    if (cacheSnapshotZipDirectory != null && cacheSnapshotZipDirectory.isDirectory()) {
      FileSystemUtils.deleteRecursive(cacheSnapshotZipDirectory);
    }
  }
}
