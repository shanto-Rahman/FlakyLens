@Test public void minimalContextAsJson(){
  CastleContext aContext=new CastleContext();
  String contextJson=model.getGson().toJson(aContext);
  Assertions.assertThat(contextJson).isEqualTo("{\"active\":true," + SDKVersion.getLibraryString() + "}");
}
