@Test public void should_decode() throws Exception {
assertThat(pm.decode((Object)null)).isNull();
assertThat(pm.decodeKey((Object)null)).isNull();
assertThat(pm.decode((List<?>)null)).isNull();
assertThat(pm.decode((Set<?>)null)).isNull();
assertThat(pm.decode((Map<?,?>)null)).isNull();
assertThat(pm.decodeFromComponents((List<?>)null)).isNull();
assertThat(pm.decode(value)).isEqualTo(value);
assertThat(pm.decodeKey(value)).isEqualTo(value);
assertThat(pm.decode(list)).isEqualTo(list);
assertThat(pm.decode(set)).isEqualTo(set);
assertThat(pm.decode(map)).isEqualTo(map);
assertThat(pm.decodeFromComponents(list)).isEqualTo(list);
}