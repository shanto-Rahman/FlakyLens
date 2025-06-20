@Test public void loggerLevelSettingBySystemProperty() throws JoranException {
assertEquals(0,listAppender.list.size());
assertEquals(1,listAppender.list.size());
}