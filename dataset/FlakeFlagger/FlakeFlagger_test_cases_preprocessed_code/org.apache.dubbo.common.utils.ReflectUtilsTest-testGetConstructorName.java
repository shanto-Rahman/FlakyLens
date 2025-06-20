@Test public void testGetConstructorName() throws Exception {
assertThat(ReflectUtils.getName(c),equalTo("(java.util.List,int[])"));
}