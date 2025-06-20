public void test_DateTime_minusDay_Gaza(){
assertEquals("2007-04-02T00:00:00.000+03:00",dt.toString());
assertEquals("2007-04-01T01:00:00.000+03:00",minus1.toString());
assertEquals("2007-03-31T00:00:00.000+02:00",minus2.toString());
}