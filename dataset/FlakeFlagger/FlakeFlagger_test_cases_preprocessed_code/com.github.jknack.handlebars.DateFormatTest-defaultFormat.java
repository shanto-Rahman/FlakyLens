@Test public void defaultFormat() throws IOException {
String expected=DateFormat.getDateInstance(DateFormat.DEFAULT,Locale.getDefault()).format(date);//ET
}