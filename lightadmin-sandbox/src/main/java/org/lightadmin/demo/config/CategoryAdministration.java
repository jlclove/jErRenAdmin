package org.lightadmin.demo.config;

import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.FieldSetConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.FiltersConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.PersistentFieldSetConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.ScreenContextConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import org.lightadmin.api.config.unit.FieldSetConfigurationUnit;
import org.lightadmin.api.config.unit.FiltersConfigurationUnit;
import org.lightadmin.api.config.unit.ScreenContextConfigurationUnit;
import org.lightadmin.api.config.utils.EntityNameExtractor;
import org.lightadmin.demo.model.Category;
import org.lightadmin.demo.model.Series;

public class CategoryAdministration extends
		AdministrationConfiguration<Category> {
	public EntityMetadataConfigurationUnit configuration(
			EntityMetadataConfigurationUnitBuilder configurationBuilder) {
		return configurationBuilder
				.nameExtractor(categoryNameExtractor())
				.singularName("产品分类")
				.pluralName("产品分类").build();
	}
	private static EntityNameExtractor<Category> categoryNameExtractor() {
		return new EntityNameExtractor<Category>() {
            @Override
            public String apply(final Category category) {
                return String.format("%s", category.getName());
            }
        };
	}

	public ScreenContextConfigurationUnit screenContext(
			ScreenContextConfigurationUnitBuilder screenContextBuilder) {
		return screenContextBuilder.screenName("产品分类管理").build();
	}

	public FieldSetConfigurationUnit listView(
			FieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder.field("name").caption("产品分类名称").build();
	}

	public FieldSetConfigurationUnit showView(
			final FieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder.field("name").caption("产品分类名称").build();
	}

	public FieldSetConfigurationUnit formView(
			final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder.field("name").caption("产品分类名称").build();
	}

	public FieldSetConfigurationUnit quickView(
			final FieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder.field("name").caption("产品分类名称").build();
	}

	public FiltersConfigurationUnit filters(
			final FiltersConfigurationUnitBuilder filterBuilder) {
		return filterBuilder.filter("产品分类名称", "name").build();
	}
}
