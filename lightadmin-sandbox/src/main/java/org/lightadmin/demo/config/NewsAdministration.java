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

import static org.lightadmin.api.config.utils.EnumElement.element;

import org.lightadmin.demo.model.News;

public class NewsAdministration extends AdministrationConfiguration<News>{
	public EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
        return configurationBuilder
                .nameExtractor(newsNameExtractor())
                .singularName("新闻")
                .pluralName("新闻列表")
                .build();
    }
	private static EntityNameExtractor<News> newsNameExtractor() {
		return new EntityNameExtractor<News>() {
            @Override
            public String apply(final News news) {
                return String.format("%s", news.getTitle());
            }
        };
	}

    public ScreenContextConfigurationUnit screenContext(ScreenContextConfigurationUnitBuilder screenContextBuilder) {
        return screenContextBuilder.screenName("新闻管理").build();
    }

    public FieldSetConfigurationUnit listView(FieldSetConfigurationUnitBuilder fragmentBuilder) {
        return fragmentBuilder
                .field("title").caption("标题")
                .field("type").caption("分类").enumeration(
                        element("公司新闻", "公司新闻"),
                        element("行业新闻", "行业新闻"))
                .field("releaseDate").caption("发布日期")
                .field("content").caption("内容").build();
    }

    public FieldSetConfigurationUnit showView(final FieldSetConfigurationUnitBuilder fragmentBuilder) {
        return fragmentBuilder
        		.field("title").caption("标题")
        		.field("type").caption("分类").enumeration(
                        element("公司新闻", "公司新闻"),
                        element("行业新闻", "行业新闻"))
                .field("releaseDate").caption("发布日期")
                .field("content").caption("内容").build();
    }

    public FieldSetConfigurationUnit formView(final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder) {
        return fragmentBuilder
        		.field("title").caption("标题")
        		.field("type").caption("分类").enumeration(
                        element("公司新闻", "公司新闻"),
                        element("行业新闻", "行业新闻"))
                .field("releaseDate").caption("发布日期")
                .field("content").caption("内容").build();
    }

    public FieldSetConfigurationUnit quickView(final FieldSetConfigurationUnitBuilder fragmentBuilder) {
        return fragmentBuilder
        		.field("title").caption("标题")
        		.field("type").caption("分类").enumeration(
                        element("公司新闻", "公司新闻"),
                        element("行业新闻", "行业新闻"))
                .field("releaseDate").caption("发布日期")
                .field("content").caption("内容").build();
    }

    public FiltersConfigurationUnit filters(final FiltersConfigurationUnitBuilder filterBuilder) {
        return filterBuilder
        		.filter("标题", "title")
        		.filter("分类", "type")
        		.filter("发布日期", "releaseDate")
                .filter("内容", "content").build();
    }
}
