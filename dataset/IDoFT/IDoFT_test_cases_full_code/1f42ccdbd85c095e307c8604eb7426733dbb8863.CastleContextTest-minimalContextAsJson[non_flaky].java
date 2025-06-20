@Test public void minimalContextAsJson(){
  CastleContext aContext=new CastleContext();
  String contextJson=model.getGson().toJson(aContext);
  JsonParser parser=new JsonParser();
  String expected="{\"active\":true," + SDKVersion.getLibraryString() + "}";
  Assertions.assertThat(parser.parse(contextJson)).isEqualTo(parser.parse(expected));
}
