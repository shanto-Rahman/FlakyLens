@Test public void testToStringWithCollections(){
assertThat(Type.List.of(Type.Int).toString(list)).isEqualTo("[1,2,3]");
assertThat(Type.Set.of(Type.Int).toString(set)).isEqualTo("{1,2,3}");
assertThat(Type.Map.of(Type.Int,Type.Int).toString(ImmutableMap.of(1,1,2,2))).isEqualTo("{1:1,2:2}");
}