@Test public void propertyPlaceholderse() throws Exception {
assertEquals("two",this.context.getBean(PlaceholderConfig.class).getFoo());
}