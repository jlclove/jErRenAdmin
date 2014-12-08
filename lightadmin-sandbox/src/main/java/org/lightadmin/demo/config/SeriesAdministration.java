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
import org.lightadmin.demo.model.Address;
import org.lightadmin.demo.model.Category;
import org.lightadmin.demo.model.Series;

public class SeriesAdministration extends AdministrationConfiguration<Series> {
	public EntityMetadataConfigurationUnit configuration(
			EntityMetadataConfigurationUnitBuilder configurationBuilder) {
		return configurationBuilder
				.nameExtractor(seriesNameExtractor())
				.singularName("产品系列")
				.pluralName("产品系列").build();
	}

	private static EntityNameExtractor<Series> seriesNameExtractor() {
		return new EntityNameExtractor<Series>() {
            @Override
            public String apply(final Series series) {
                return String.format("%s", series.getName());
            }
        };
	}

	public ScreenContextConfigurationUnit screenContext(
			ScreenContextConfigurationUnitBuilder screenContextBuilder) {
		return screenContextBuilder.screenName("产品系列管理").build();
	}

	public FieldSetConfigurationUnit listView(
			FieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder
				.field("name").caption("产品系列名称")
				.field("category").caption("所属产品分类").build();
	}

	public FieldSetConfigurationUnit showView(
			final FieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder
				.field("name").caption("产品系列名称")
				.field("category").caption("所属产品分类").build();
	}

	public FieldSetConfigurationUnit formView(
			final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder
				.field("name").caption("产品系列名称")
				.field("category").caption("所属产品分类").build();
	}

	public FieldSetConfigurationUnit quickView(
			final FieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder
				.field("name").caption("产品系列名称")
				.field("category").caption("所属产品分类").build();
	}

	public FiltersConfigurationUnit filters(
			final FiltersConfigurationUnitBuilder filterBuilder) {
		return filterBuilder
				.filter("产品系列名称", "name")
				.filter("所属产品分类", "category").build();
	}
}
