@Test public void should_format_xml_string_without_xml_declaration_prettily(){
assertThat(xmlPrettyFormat(xmlString)).isEqualTo(EXPECTED_FORMATTED_XML.substring("<?xml version='1.0' encoding='UTF-8'?>\n".length()));
}