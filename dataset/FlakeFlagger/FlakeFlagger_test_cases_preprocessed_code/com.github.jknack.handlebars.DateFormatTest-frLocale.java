@Test public void frLocale() throws IOException {
String expected=DateFormat.getDateInstance(DateFormat.SHORT,Locale.FRENCH).format(date);//ET
}