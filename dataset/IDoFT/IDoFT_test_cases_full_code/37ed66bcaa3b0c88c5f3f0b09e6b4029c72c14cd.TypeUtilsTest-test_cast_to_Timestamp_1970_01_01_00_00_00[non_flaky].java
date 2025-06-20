public void test_cast_to_Timestamp_1970_01_01_00_00_00() throws Exception {
  JSON.defaultTimeZone=TimeZone.getTimeZone("Asia/Shanghai");
  Assert.assertEquals(new Timestamp(0),TypeUtils.castToTimestamp("1970-01-01 08:00:00"));
}
