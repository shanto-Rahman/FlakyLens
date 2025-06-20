@Test public void should_derive_base_class() throws Exception {
assertThat(proxifier.<CompleteBean>deriveBaseClass(proxy)).isEqualTo(CompleteBean.class);
}