@Test public void should_encode() throws Exception {
assertThat(pm.encode((Object)null)).isNull();
assertThat(pm.encodeKey((Object)null)).isNull();
assertThat(pm.encode((List<?>)null)).isNull();
assertThat(pm.encode((Set<?>)null)).isNull();
assertThat(pm.encode((Map<?,?>)null)).isNull();
assertThat(pm.encodeToComponents((List<?>)null)).isNull();
assertThat(pm.encode(value)).isEqualTo(value);
assertThat(pm.encodeKey(value)).isEqualTo(value);
assertThat(pm.encode(list)).isEqualTo(list);
assertThat(pm.encode(set)).isEqualTo(set);
assertThat(pm.encode(map)).isEqualTo(map);
assertThat(pm.encodeToComponents(list)).isEqualTo(list);
assertThat(pm.encodeToComponents(list)).isEqualTo(list);
}