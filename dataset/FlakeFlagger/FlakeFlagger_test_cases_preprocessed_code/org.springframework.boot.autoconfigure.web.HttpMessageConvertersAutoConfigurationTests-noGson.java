@Test public void noGson() throws Exception {
assertTrue(this.context.getBeansOfType(Gson.class).isEmpty());
assertTrue(this.context.getBeansOfType(GsonHttpMessageConverter.class).isEmpty());
}