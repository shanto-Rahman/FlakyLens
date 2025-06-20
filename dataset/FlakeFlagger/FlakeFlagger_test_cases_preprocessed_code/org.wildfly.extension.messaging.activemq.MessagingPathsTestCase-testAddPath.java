@Test public void testAddPath() throws Exception {
assertTrue("the specific relative path must be prepended by the resolved default relative-to, resolvedJournalPath=" + resolvedJournalPath + ", MY_SERVER_DATA_DIR"+ MY_SERVER_DATA_DIR,resolvedJournalPath.startsWith(MY_SERVER_DATA_DIR));
assertTrue(resolvedJournalPath.endsWith(MY_RELATIVE_JOURNAL_DIR));
assertEquals("the speficic absolute path must not be prepended by the resolved default relative-to, resolvedBindingsPath=" + resolvedBindingsPath,MY_ABSOLUTE_BINDINGS_DIR,resolvedBindingsPath);
assertTrue("the default path must be prepended by the resolved specific relative-to, resolvedPagingPath=" + resolvedPagingPath,resolvedPagingPath.startsWith(MY_PAGING_RELATIVE_TO_DIR));
assertTrue(resolvedPagingPath.endsWith(DEFAULT_PAGING_DIR));
assertTrue("by default, the default path MUST prepended by the resolved default relative-to, resolvedLargeMessagePath=" + resolvedLargeMessagePath,resolvedLargeMessagePath.startsWith(MY_SERVER_DATA_DIR));
assertTrue(resolvedLargeMessagePath.endsWith(DEFAULT_LARGE_MESSAGE_DIR));
}