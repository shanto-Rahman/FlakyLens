@DisplayName("td: escape text, emphasize, and allow free width") @Test public void td2(){
assertThat(tablecell.render(TagOutputFormat.html),is("<td colspan='2' sometag='custom&value' align='right'><b><i>display &amp; text</i></b></td>"));
assertThat(tablecell.render(TagOutputFormat.text),is("display & text"));
assertThat(tablecell.render(TagOutputFormat.tsv),is("display & text"));
}