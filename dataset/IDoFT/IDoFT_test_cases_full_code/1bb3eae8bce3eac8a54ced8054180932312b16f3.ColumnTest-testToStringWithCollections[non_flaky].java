@Test public void testToStringWithCollections(){
  java.util.List<Integer> list=Arrays.asList(1,2,3);
  java.util.TreeSet<Integer> set=new TreeSet(list);
  java.util.Map<Integer,Integer> m=new TreeMap<>();
  m.put(1,1);
  m.put(2,2);
  String mapString=Type.Map.of(Type.Int,Type.Int).toString(ImmutableMap.of(1,1,2,2));
  assertThat(Type.List.of(Type.Int).toString(list)).isEqualTo("[1,2,3]");
  assertThat(Type.Set.of(Type.Int).toString(set)).isEqualTo("{1,2,3}");
  assertThat(Type.Map.of(Type.Int,Type.Int).toString(m)).isEqualTo("{1:1,2:2}");
}
