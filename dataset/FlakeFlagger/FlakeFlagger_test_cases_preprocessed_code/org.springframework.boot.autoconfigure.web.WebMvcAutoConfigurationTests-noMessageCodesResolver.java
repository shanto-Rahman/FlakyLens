@Test public void noMessageCodesResolver() throws Exception {
assertNull(this.context.getBean(WebMvcAutoConfigurationAdapter.class).getMessageCodesResolver());
}