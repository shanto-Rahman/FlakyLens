@Test public void gridFsTemplateExists(){
assertEquals(1,this.context.getBeanNamesForType(GridFsTemplate.class).length);
}