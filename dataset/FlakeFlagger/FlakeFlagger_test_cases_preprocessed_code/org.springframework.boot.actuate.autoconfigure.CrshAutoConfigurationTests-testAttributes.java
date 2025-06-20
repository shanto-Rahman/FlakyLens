@Test public void testAttributes() throws Exception {
assertTrue(attributes.containsKey("spring.version"));
assertTrue(attributes.containsKey("spring.beanfactory"));
assertEquals(this.context.getBeanFactory(),attributes.get("spring.beanfactory"));
}