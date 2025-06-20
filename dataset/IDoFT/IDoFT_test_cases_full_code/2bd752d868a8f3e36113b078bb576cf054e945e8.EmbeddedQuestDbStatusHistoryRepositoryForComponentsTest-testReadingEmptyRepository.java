@Test public void testReadingEmptyRepository() throws Exception {
  final StatusHistory result=testSubject.getProcessGroupStatusHistory(ROOT_GROUP_ID,START,END,PREFERRED_DATA_POINTS);
  assertStatusHistoryIsEmpty(result);
}
