package org.logSpin.annotationProcess;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
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
        classList.forEach(element -> {
            System.out.println("process ------------"+element.getSimpleName());

        });
        return false;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }
}
