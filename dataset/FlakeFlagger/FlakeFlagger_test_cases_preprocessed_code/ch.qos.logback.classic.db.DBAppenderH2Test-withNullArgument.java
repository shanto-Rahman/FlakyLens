@Test public void withNullArgument() throws SQLException {
if (rs.next()) {
assertEquals(event.getTimeStamp(),rs.getLong(DBAppender.TIMESTMP_INDEX));
assertEquals(event.getFormattedMessage(),rs.getString(DBAppender.FORMATTED_MESSAGE_INDEX));
}
}