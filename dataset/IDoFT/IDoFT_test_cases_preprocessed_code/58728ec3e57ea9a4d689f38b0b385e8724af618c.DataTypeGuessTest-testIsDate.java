public void testIsDate(){
assertEquals("yyyy-MM-dd",DataTypeGuess.getDateFormat("2010-11-12"));
assertNull(DataTypeGuess.getDateFormat("2010-13-12"));
assertEquals("MM/dd/yyyy",DataTypeGuess.getDateFormat("11/12/2010"));
assertNull(DataTypeGuess.getDateFormat("13/12/2010"));
}