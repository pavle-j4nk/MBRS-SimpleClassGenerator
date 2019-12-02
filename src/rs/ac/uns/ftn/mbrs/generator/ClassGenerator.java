package rs.ac.uns.ftn.mbrs.generator;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import rs.ac.uns.ftn.mbrs.example.Product;
import rs.ac.uns.ftn.mbrs.model.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ClassGenerator {
    private static final String PACKAGE_SEPARATOR = ".";
    private static final String FILE_EXTENSION = ".java";

    private Template template;

    public ClassGenerator() {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(Product.class, "/template/");
        configuration.setObjectWrapper(new DefaultObjectWrapper());

        try {
            template = configuration.getTemplate("class.ftl");
        } catch (IOException e) {
            throw new GeneratorException(e);
        }
    }

    public String generate(FMClass fmClass) {
        Map<String, Object> model = new HashMap<>();
        model.put("class", fmClass);
        model.put("imports", collectImports(fmClass));
        model.put("properties", fmClass.getProperties());
        model.put("methods", fmClass.getMethods());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            template.process(model, new OutputStreamWriter(byteArrayOutputStream));
        } catch (IOException | TemplateException e) {
            throw new GeneratorException(e);
        }

        String source = byteArrayOutputStream.toString();
        persist(fmClass.getFullName(), source);

        return source;
    }

    private Set<String> collectImports(FMClass fmClass) {
        Set<String> propertyTypes = fmClass.getProperties().stream().map(FMProperty::getType).map(FMType::getFullName)
                .collect(Collectors.toSet());
        Set<String> methodReturnTypes = fmClass.getMethods().stream().map(FMMethod::getReturnType).filter(Objects::nonNull)
                .map(FMType::getFullName).collect(Collectors.toSet());
        Set<String> methodParameterTypes = fmClass.getMethods().stream().map(FMMethod::getParameters)
                .flatMap(Collection::stream).map(FMParameter::getType).map(FMType::getFullName).collect(Collectors.toSet());

        Set<String> imports = new HashSet<>();
        imports.addAll(propertyTypes);
        imports.addAll(methodReturnTypes);
        imports.addAll(methodParameterTypes);

        FMClass superClass = fmClass.getSuperClass();
        if (superClass != null) {
            imports.add(superClass.getFullName());
        }

        return imports;
    }

    private void persist(String classFullName, String source) {
        String dstFileName = classFullName.replace(PACKAGE_SEPARATOR, File.separator) + FILE_EXTENSION;
        File dstFile = new File("src", dstFileName);
        dstFile.getParentFile().mkdirs();

        try {
            Files.writeString(dstFile.toPath(), source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
