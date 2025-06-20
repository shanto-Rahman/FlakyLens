@Test @DisplayName("Test allowed value") void testAllowedValue(){
SlimefunItem item=TestUtilities.mockSlimefunItem(plugin,"MATERIAL_SETTING_TEST_2",new CustomItem(Material.DIAMOND,"&cTest"));//RW
MaterialTagSetting setting=new MaterialTagSetting(item,"test",tag);//RW
item.register(plugin);//RW
List<String> tagContents=tag.getValues().stream().map(Material::name).collect(Collectors.toList());//RW
}