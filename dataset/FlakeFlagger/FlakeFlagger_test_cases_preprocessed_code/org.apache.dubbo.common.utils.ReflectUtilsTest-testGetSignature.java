@Test public void testGetSignature() throws Exception {
assertThat(ReflectUtils.getSignature("greeting",m.getParameterTypes()),equalTo("greeting([I)"));
}