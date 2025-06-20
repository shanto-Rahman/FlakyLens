@Test public void itConvertsSetsToLists(){
  Set<Integer> ints=Sets.newHashSet(1,2,3);
  ints=new TreeSet<Integer>(ints);
  List<?> o=(List<?>)filter.filter(ints,null);
  assertThat(o).isEqualTo(Lists.newArrayList(1,2,3));
}
