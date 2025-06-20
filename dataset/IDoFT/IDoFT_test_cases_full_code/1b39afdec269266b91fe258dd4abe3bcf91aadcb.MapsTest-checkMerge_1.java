@Test public void checkMerge_1() throws Exception {
  Map<String,?> merged=Maps.merge(Stream.of(getClass().getField("one").getAnnotations()).collect(Collectors.toList()));
  Assert.assertEquals(Maps.of("a",Arrays.asList("foo","bar","baz"),"cpt3",true,"b",Arrays.asList(1,1,1,2,2),"c",true),merged);
}
