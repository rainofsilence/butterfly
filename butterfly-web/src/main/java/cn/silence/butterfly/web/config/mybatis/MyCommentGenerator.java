package cn.silence.butterfly.web.config.mybatis;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;


/**
 * @author rainofsilence
 * @version 1.0.0
 * @since 2023/5/7 17:38
 */
public class MyCommentGenerator implements CommentGenerator {

    private Properties properties;

    private boolean suppressDate;

    private boolean suppressAllComments;

    /**
     * If suppressAllComments is true, this option is ignored.
     */
    private boolean addRemarkComments;

    private SimpleDateFormat dateFormat;

    private static final SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private FullyQualifiedTable fullyQualifiedTable;

    public MyCommentGenerator() {
        super();
        properties = new Properties();
        suppressDate = false;
        suppressAllComments = false;
        addRemarkComments = false;
    }

    /**
     * 默认配置
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        suppressDate = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

        suppressAllComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

        addRemarkComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));

        String dateFormatString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
        if (StringUtility.stringHasValue(dateFormatString)) {
            dateFormat = new SimpleDateFormat(dateFormatString);
        }
    }

    /**
     * 实体类添加的注释
     *
     * @param topLevelClass
     * @param introspectedTable
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass,
                                     IntrospectedTable introspectedTable) {
        if (suppressAllComments || !addRemarkComments) {
            return;
        }

        StringBuilder sbHeader = new StringBuilder();
        sbHeader.append("/**\n *");

        String remarks = introspectedTable.getRemarks();
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            for (String remarkLine : remarkLines) {
                sbHeader.append(" ").append(remarkLine);
            }
        }
        sbHeader.append(" ").append(introspectedTable.getFullyQualifiedTable().toString()).append("\n");
        sbHeader.append(" *\n");
        sbHeader.append(String.format(" * @author %s\n", System.getProperty("user.name")));
        sbHeader.append(" * @version 1.0.0\n");
        sbHeader.append(String.format(" * @since %s\n", defaultDateFormat.format(new Date())));
        sbHeader.append(" */");
        topLevelClass.addJavaDocLine(sbHeader.toString());
    }

    /**
     * 实体类的属性注释，数据库中自定义注释
     *
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field,
                                IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        field.addJavaDocLine("/**");
        String remarks = introspectedColumn.getRemarks();
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            for (String remarkLine : remarkLines) {
                field.addJavaDocLine(" * " + remarkLine);
            }
        } else {
            field.addJavaDocLine(" *");
        }
        field.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        field.addJavaDocLine("/**");
        FullyQualifiedTable fullyQualifiedTable = introspectedTable.getFullyQualifiedTable();
        field.addJavaDocLine(fullyQualifiedTable == null ? "*" : String.valueOf(fullyQualifiedTable));
        field.addJavaDocLine(" */");
    }


    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
    }


    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
    }

    // 不需要get方法的注释
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }

    // 不需要set方法的注释
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {
    }

    @Override
    public void addComment(XmlElement xmlElement) {

    }

    @Override
    public void addRootComment(XmlElement rootElement) {
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
    }
}
