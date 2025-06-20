public void testLocalDateTimeVariable(){
assertEquals(todayYear,date1.getYear());
assertEquals(todayMonth + 1,date1.getMonthOfYear());
assertEquals(todayDate,date1.getDayOfMonth());
assertEquals(2010,date1.getYear());
assertEquals(11,date1.getMonthOfYear());
assertEquals(10,date1.getDayOfMonth());
assertEquals(10,date1.getHourOfDay());
assertEquals(15,date1.getMinuteOfHour());
assertNotNull(processInstance);
assertEquals(processInstanceId,processInstance.getId());
assertNull(processInstance);
assertNotNull(processInstance);
assertEquals(processInstanceId,processInstance.getId());
}