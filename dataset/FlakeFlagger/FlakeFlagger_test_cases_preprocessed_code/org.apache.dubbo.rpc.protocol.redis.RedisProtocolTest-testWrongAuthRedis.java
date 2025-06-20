@Test public void testWrongAuthRedis(){
assertThat(value,is(nullValue()));
if (e.getCause() instanceof JedisConnectionException && e.getCause().getCause() instanceof JedisDataException) {
Assert.assertEquals("ERR invalid password",e.getCause().getCause().getMessage());
Assert.fail("no invalid password exception!");
}
}