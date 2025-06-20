@Test public void assertGetMap(){
assertThat(new ShardingItemParameters("0=A,1=B,2=C").getMap(),is(expected));
}