@Test public void should_use_equals_and_hashcode() throws Exception {
assertThat(meta1).isNotEqualTo(meta2);
assertThat(meta1).isNotEqualTo(meta3);
assertThat(meta1).isNotEqualTo(meta4);
assertThat(meta1).isEqualTo(meta5);
assertThat(meta1.hashCode()).isNotEqualTo(meta2.hashCode());
assertThat(meta1.hashCode()).isNotEqualTo(meta3.hashCode());
assertThat(meta1.hashCode()).isNotEqualTo(meta4.hashCode());
assertThat(meta1.hashCode()).isEqualTo(meta5.hashCode());
assertThat(pms).containsOnly(meta1,meta2,meta3,meta4);
}