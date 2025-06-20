@Test public void testDateTimeTimestamp() throws Exception {
assertEquals(Date.class,date.getClass());
assertEquals(dateTimeStr,new SimpleDateFormat(dateFormat[0]).format(date));
assertEquals(java.sql.Time.class,time.getClass());
assertEquals(timeStr,new SimpleDateFormat(dateFormat[2]).format(time));
assertEquals(java.sql.Date.class,sqlDate.getClass());
assertEquals(dateStr,new SimpleDateFormat(dateFormat[1]).format(sqlDate));
assertEquals(java.sql.Timestamp.class,timestamp.getClass());
assertEquals(dateTimeStr,new SimpleDateFormat(dateFormat[0]).format(timestamp));
}