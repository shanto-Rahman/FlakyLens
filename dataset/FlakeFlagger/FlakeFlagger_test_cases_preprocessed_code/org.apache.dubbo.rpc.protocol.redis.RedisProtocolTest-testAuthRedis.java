@Test public void testAuthRedis(){
assertThat(value,is(nullValue()));
assertThat(value,is("newValue"));
assertThat(value,is(nullValue()));
assertThat(value,is("newValue"));
assertThat(value,is(actual));
Assert.fail("jedis gets the result comparison is error!");
if (jedis != null) {
}
assertThat(value,is(nullValue()));
}