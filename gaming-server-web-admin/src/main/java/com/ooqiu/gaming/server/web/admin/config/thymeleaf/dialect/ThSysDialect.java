package com.ooqiu.gaming.server.web.admin.config.thymeleaf.dialect;

import com.ooqiu.gaming.server.web.admin.config.thymeleaf.tag.ThSysDictTagProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashSet;
import java.util.Set;

/**
 * 系统方言
 */
public class ThSysDialect extends AbstractProcessorDialect {

    private static final String DIALECT_NAME="ThSys Dialect";

    public ThSysDialect() {
        // 设置自定义方言与“方言处理器”优先级相同
        super(DIALECT_NAME, "thSys", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    /**
     * 元素处理器
     * @param dialectPrefix 方言前缀
     * @return
     */
    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        Set<IProcessor> processors = new HashSet<IProcessor>();

        // 添加自定义标签
        processors.add(new ThSysDictTagProcessor(dialectPrefix));
        processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix));
        return processors;
    }
}
