package org.logSpin.annotationProcess;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SupportedAnnotationTypes({"org.logSpin.annotation.Plugin"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class DefaultSpinAnnotationProcess extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if(roundEnv.processingOver()){
            return true;
        }

        List<Element> classList = new ArrayList<>(roundEnv.getElementsAnnotatedWith(org.logSpin.annotation.Plugin.class));
        write(classList);
        return false;
    }

    private void write(List<Element> classList) {
        String fileName = "Plugins.txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            classList.forEach(element -> {
                try {
                    writer.write(((TypeElement)element).getQualifiedName()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }
}
