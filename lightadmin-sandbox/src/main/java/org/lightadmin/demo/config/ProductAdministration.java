package org.lightadmin.demo.config;

import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.*;
import org.lightadmin.api.config.unit.*;
import org.lightadmin.demo.model.Product;

import static org.lightadmin.api.config.utils.Editors.wysiwyg;
import static org.lightadmin.api.config.utils.EnumElement.element;

@SuppressWarnings("unused")
public class ProductAdministration extends AdministrationConfiguration<Product> {

    public EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
        return configurationBuilder
                .nameField("产品名称")
                .singularName("产品")
                .pluralName("产品")
                .build();
    }

    public ScreenContextConfigurationUnit screenContext(ScreenContextConfigurationUnitBuilder screenContextBuilder) {
        return screenContextBuilder.screenName("产品管理").build();
    }

    public FieldSetConfigurationUnit listView(FieldSetConfigurationUnitBuilder fragmentBuilder) {
        return fragmentBuilder
                .field("name").caption("产品名称")
                .field("series").caption("产品系列")
                .field("description").caption("描述")
                .field("price").caption("价格")
                .field("retired").caption("是否无货")
                .field("releaseDate").caption("上架日期")
                .field("releaseTime").caption("上架时间")
                .field("picture").caption("图片").build();
    }

    public FieldSetConfigurationUnit showView(final FieldSetConfigurationUnitBuilder fragmentBuilder) {
        return fragmentBuilder
                .field("name").caption("产品名称")
                .field("series").caption("产品系列")
                .field("description").caption("描述")
                .field("price").caption("价格")
                .field("retired").caption("是否无货")
                .field("releaseDate").caption("上架日期")
                .field("releaseTime").caption("上架时间")
                .field("picture").caption("图片").build();
    }

    public FieldSetConfigurationUnit formView(final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder) {
        return fragmentBuilder
                .field("name").caption("产品名称")
                .field("series").caption("产品系列")
                .field("description").caption("描述").editor(wysiwyg())
                .field("price").caption("价格")
                .field("releaseDate").caption("上架日期")
                .field("releaseTime").caption("上架时间")
                .field("retired").caption("是否无货")
                .field("picture").caption("图片").build();
    }

    public FieldSetConfigurationUnit quickView(final FieldSetConfigurationUnitBuilder fragmentBuilder) {
        return fragmentBuilder
                .field("uuid").caption("产品编号")
                .field("name").caption("产品名称")
                .field("series").caption("产品系列")
                .field("description").caption("描述")
                .field("retired").caption("是否无货")
                .field("releaseDate").caption("上架日期")
                .field("picture").caption("图片").build();
    }

    public FiltersConfigurationUnit filters(final FiltersConfigurationUnitBuilder filterBuilder) {
        return filterBuilder
                .filter("产品名称", "name")
                .filter("产品系列", "series")
                .filter("描述", "description")
                .filter("价格", "price")
                .filter("上架日期", "releaseDate")
                .filter("上架时间", "releaseTime")
                .filter("是否无货", "retired").build();
    }

//    public SidebarsConfigurationUnit sidebars(final SidebarsConfigurationUnitBuilder sidebarsBuilder) {
//        return sidebarsBuilder
//                .sidebar("Custom Sidebar", "/WEB-INF/admin/sidebars/sidebar.jsp")
//                .build();
//    }
}
