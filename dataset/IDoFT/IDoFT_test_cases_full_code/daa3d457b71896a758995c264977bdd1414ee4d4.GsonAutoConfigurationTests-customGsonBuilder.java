@Test public void customGsonBuilder(){
  this.contextRunner.withUserConfiguration(GsonBuilderConfig.class).run((context) -> {
    Gson gson=context.getBean(Gson.class);
    assertThat(gson.toJson(new DataObject())).isEqualTo("{\"data\":1,\"owner\":null}");
  }
);
}
