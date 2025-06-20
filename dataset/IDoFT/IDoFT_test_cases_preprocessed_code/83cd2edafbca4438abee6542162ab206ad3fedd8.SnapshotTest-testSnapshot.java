@Test public void testSnapshot(){
new File(snapshot.getFile()).delete();//RO
assertEquals(Snapshot.Result.INITIAL,snapshot.getResult());
assertEquals(Snapshot.Result.MATCHES,snapshot.getResult());
assertNull(snapshot.getMessage());
assertEquals(Snapshot.Result.MISMATCH,snapshot.getResult());
assertTrue(new File(snapshot.getFile() + ".tmp").exists());//RO
assertEquals(Snapshot.Result.MATCHES,snapshot.getResult());
assertNull(snapshot.getMessage());
assertFalse(new File(snapshot.getFile() + ".tmp").exists());//RO
}