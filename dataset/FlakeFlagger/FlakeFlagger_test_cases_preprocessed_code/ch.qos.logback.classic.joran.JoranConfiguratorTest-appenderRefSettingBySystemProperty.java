@Test public void appenderRefSettingBySystemProperty() throws JoranException {
assertEquals(0,listAppender.list.size());
assertEquals(1,listAppender.list.size());
}