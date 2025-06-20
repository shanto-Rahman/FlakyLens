@Test public void checkMerge_1() throws Exception {
  Map<String,?> merged=Maps.merge(Stream.of(getClass().getField("one").getAnnotations()).collect(Collectors.toList()));
  Assert.assertTrue(Maps.of("a",Arrays.asList("foo","bar","baz"),"cpt3",true,"b",Arrays.asList(1,1,1,2,2),"c",true).equals(merged) || Maps.of("a",Arrays.asList("foo","bar","baz"),"cpt3",true,"b",Arrays.asList(2,2,1,1,1),"c",true).equals(merged) || Maps.of("a",Arrays.asList("baz","foo","bar"),"cpt3",true,"b",Arrays.asList(1,1,1,2,2),"c",true).equals(merged)|| Maps.of("a",Arrays.asList("baz","foo","bar"),"cpt3",true,"b",Arrays.asList(2,2,1,1,1),"c",true).equals(merged));
}
