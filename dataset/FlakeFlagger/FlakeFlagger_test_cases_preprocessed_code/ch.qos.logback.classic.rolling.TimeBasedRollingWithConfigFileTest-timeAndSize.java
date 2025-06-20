@Test public void timeAndSize() throws Exception {
assertTrue("exitenceCount=" + eCount + ", expectedFilenameList.size="+ expectedFilenameList.size(),eCount >= 4 && eCount > expectedFilenameList.size() / 2);
}