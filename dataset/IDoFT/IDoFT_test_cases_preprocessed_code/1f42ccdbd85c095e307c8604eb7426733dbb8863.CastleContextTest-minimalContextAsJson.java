@Test public void minimalContextAsJson(){
Assertions.assertThat(contextJson).isEqualTo("{\"active\":true," + SDKVersion.getLibraryString() + "}");
}