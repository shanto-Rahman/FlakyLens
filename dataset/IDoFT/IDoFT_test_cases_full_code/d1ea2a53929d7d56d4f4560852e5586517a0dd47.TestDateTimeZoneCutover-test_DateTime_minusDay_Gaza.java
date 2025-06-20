public void test_DateTime_minusDay_Gaza(){
  DateTime dt=new DateTime(2007,4,2,0,0,0,0,MOCK_GAZA);
  assertEquals("2007-04-02T00:00:00.000+03:00",dt.toString());
  DateTime minus1=dt.minusDays(1);
  assertEquals("2007-04-01T01:00:00.000+03:00",minus1.toString());
  DateTime minus2=dt.minusDays(2);
  assertEquals("2007-03-31T00:00:00.000+02:00",minus2.toString());
}
