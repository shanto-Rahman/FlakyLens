@Test public void itConvertsSetsToLists(){
  Set<Integer> ints=Sets.newHashSet(1,2,3);
  List<?> o=(List<?>)filter.filter(ints,null);
  assertThat(o).isEqualTo(Lists.newArrayList(1,2,3));
}
