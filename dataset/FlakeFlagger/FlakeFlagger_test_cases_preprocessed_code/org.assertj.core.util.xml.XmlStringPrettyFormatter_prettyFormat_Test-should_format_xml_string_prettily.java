@Test public void should_format_xml_string_prettily(){
assertThat(xmlPrettyFormat(xmlString)).isEqualTo(EXPECTED_FORMATTED_XML);
}