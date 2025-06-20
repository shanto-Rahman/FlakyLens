@Test public void testProteinSequenceFactoring() throws Exception {
if (CDSs != null) {
if (CDSs.size() == 1) {
if (codedBy != null) {
Assert.assertNotNull(parentSeq);
Assert.assertTrue(!parentSeq.getSequenceAsString().isEmpty());
}
}
}
Thread.sleep(500);
}