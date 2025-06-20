@Test public void should_build() throws Exception {
assertThat(wrapper.getTarget()).isSameAs(target);
assertThat(wrapper.getDirtyMap()).isSameAs(dirtyMap);
assertThat(Whitebox.getInternalState(wrapper,"setter")).isSameAs(setter);
assertThat(Whitebox.getInternalState(wrapper,"propertyMeta")).isSameAs(propertyMeta);
}