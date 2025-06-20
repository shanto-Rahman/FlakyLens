@Test public void propertyPlaceholdersOverride() throws Exception {
assertEquals("spam",this.context.getBean(PlaceholderConfig.class).getFoo());
}