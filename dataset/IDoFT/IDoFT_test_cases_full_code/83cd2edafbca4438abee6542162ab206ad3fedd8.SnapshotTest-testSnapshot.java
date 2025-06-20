@Test public void testSnapshot(){
  Snapshot snapshot=Snapshot.of("test","This is actual value");
  assertMatchesSnapshot("snapshot",snapshot);
  new File(snapshot.getFile()).delete();
  snapshot.compareOrRecord();
  assertEquals(Snapshot.Result.INITIAL,snapshot.getResult());
  assertMatchesSnapshot("InitialMessage",removeCurrentPth(snapshot.getMessage()));
  snapshot.compareOrRecord();
  assertEquals(Snapshot.Result.MATCHES,snapshot.getResult());
  assertNull(snapshot.getMessage());
  FileUtil.writeFile(snapshot.getFile(),"Some random junk");
  try {
    snapshot.compareOrRecord();
  }
 catch (  AssertionError e) {
    assertMatchesSnapshot("MismatchError",e.getMessage());
  }
  assertEquals(Snapshot.Result.MISMATCH,snapshot.getResult());
  assertMatchesSnapshot("errorMessage",removeCurrentPth(snapshot.getMessage()));
  assertTrue(new File(snapshot.getFile() + ".tmp").exists());
  FileUtil.copyFrom(snapshot.getFile(),snapshot.getTempFile());
  snapshot.compareOrRecord();
  assertEquals(Snapshot.Result.MATCHES,snapshot.getResult());
  assertNull(snapshot.getMessage());
  assertFalse(new File(snapshot.getFile() + ".tmp").exists());
}
